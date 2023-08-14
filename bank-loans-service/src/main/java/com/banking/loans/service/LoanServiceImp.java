package com.banking.loans.service;

import com.banking.loans.Exceptions.LessThanDueDate;
import com.banking.loans.Exceptions.LoanNotFoundException;
import com.banking.loans.Exceptions.noLoanException;
import com.banking.loans.dto.request.ReqApplyLoan;
import com.banking.loans.dto.response.ResApplyLoan;
import com.banking.loans.dto.response.ResBalance;
import com.banking.loans.dto.response.ResRepay;
import com.banking.loans.model.LoanModel;

import com.banking.loans.repo.LoanRepoImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.TimeUnit;


@Service
@Slf4j
public class LoanServiceImp implements LoanService{
    @Autowired
    private LoanRepoImp repo;

    @Override
    public ResApplyLoan applyLoan(ReqApplyLoan loan) {
        log.info(loan.toString());
        float interest=0;
        switch (loan.getTypeOfLoan().toUpperCase()) {
            case "HOME":
                interest = 7;
                break;
            case "PERSONAL":
                interest = 10;
                break;
            default:
                throw new LoanNotFoundException("Sorry, we are not providing '"+loan.getTypeOfLoan()+"' loan");
        }

        return calculateEMI(interest,loan);
    }

    private ResApplyLoan calculateEMI(float interest, ReqApplyLoan loan){
        double monthlyEMI,totalAmount;
        float monthlyInterest = interest/12/100;
        monthlyEMI =Math.round(loan.getAmount()*monthlyInterest*(Math.pow((1+monthlyInterest), loan.getNumberOfMonth())/
                (Math.pow((1+monthlyInterest), loan.getNumberOfMonth())-1)));
        totalAmount =monthlyEMI*loan.getNumberOfMonth();
        log.info("MonthlyEMI amount = {} Total Amount = {}",monthlyEMI,totalAmount);
        LoanModel loanModel = LoanModel.builder().typeOfLoan(loan.getTypeOfLoan().toUpperCase())
                .ACno(loan.getAccountNo())
                .EMIAmount(monthlyEMI)
                .status("Created")
                .date(new Date())
                .numberOfMonth(loan.getNumberOfMonth())
                .totalAmount(totalAmount)
                .interest(interest)
                .build();
        LoanModel response = repo.storeLoan(loanModel);
        log.info("Loan details {}",response.toString());
        return ResApplyLoan.builder()
                .typeOfLoan(response.getTypeOfLoan())
                .numberOfMonth(response.getNumberOfMonth())
                .interest(response.getInterest())
                .EMIAmount(response.getEMIAmount())
                .totalAmount(response.getTotalAmount())
                .build();
    }

    @Override
    public ResRepay repayLoan(String accountNumber) {
        LoanModel data = repo.lastPay(accountNumber);
        log.info("initial date {}",data);
        float penalty = 0;
        if(data==null)
        {
            throw new noLoanException("No loan to repay");
        }
        else if (data.getStatus().equals("Created")) {

            return payAndStore(data,penalty);
        }
        else if (data.getStatus().equals("Pay") && data.getTotalAmount()>0 && data.getNumberOfMonth()>0) {
            LocalDateTime localDateTime = data.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            LocalDateTime nextDate = localDateTime.plusDays(30);
            long days = Math.abs(TimeUnit
                    .MILLISECONDS
                    .toDays(data.getDate().getTime() - new Date().getTime())
                    % 365);
            if(days<30){
                throw new LessThanDueDate("you payed "+(days)+" Day ago and your due date is "+nextDate);
            } else if (days>=30 && days<=35) {
                return payAndStore(data,penalty);
            }
            else {
                penalty=1000;
                return payAndStore(data,penalty);
            }

        }
        return null;
    }

    private ResRepay payAndStore(LoanModel data,float penalty){
        double repayAmount = penalty+ data.getEMIAmount();

        LoanModel loan = LoanModel.builder().typeOfLoan(data.getTypeOfLoan())
                .numberOfMonth(data.getNumberOfMonth()-1)
                .status("Pay")
                .date(new Date())
                .ACno(data.getACno())
                .EMIAmount(data.getEMIAmount())
                .totalAmount(data.getTotalAmount()- data.getEMIAmount())
                .interest(data.getInterest())
                .build();
        LoanModel response = repo.storeLoan(loan);
        LocalDateTime localDateTime = response.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime nextDate = localDateTime.plusDays(30);
        Date date = Date.from(nextDate.atZone(ZoneId.systemDefault()).toInstant());
        log.info(nextDate.toString());
        return ResRepay.builder().nextPaymentDate(date)
                .pendingDue(response.getTotalAmount()).build();
    }

    @Override
    public ResBalance pendingDue(String accountNumber) {
        return ResBalance.builder().accountNumber(accountNumber).DueAmount(repo.pendingDue(accountNumber)).build();
    }
}
