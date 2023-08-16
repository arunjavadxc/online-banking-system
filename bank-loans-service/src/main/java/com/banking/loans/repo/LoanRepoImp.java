package com.banking.loans.repo;

import com.banking.loans.model.LoanModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Slf4j
@Repository
public class LoanRepoImp{
    @Autowired
    private LoanRepo loanRepo;
    public LoanModel storeLoan(LoanModel loan){
        return loanRepo.save(loan);
    }

    public LoanModel lastPay(String accountNumber) {
        List<LoanModel> loanHistory = loanRepo.findDateByACno(accountNumber);
        return loanHistory.get(loanHistory.size()-1);
    }

    public double pendingDue(String accountNumber) {
        List<LoanModel> loanHistory = loanRepo.findDateByACno(accountNumber);
        return loanHistory.get(loanHistory.size()-1).getTotalAmount();
    }
}
