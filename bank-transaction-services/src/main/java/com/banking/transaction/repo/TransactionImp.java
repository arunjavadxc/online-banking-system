package com.banking.transaction.repo;

import com.banking.transaction.Exceptions.InsufficientBalance;
import com.banking.transaction.dto.TransactionRequest;
import com.banking.transaction.dto.TransactionResponse;
import com.banking.transaction.model.TransactionModel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Repository
@Slf4j
public class TransactionImp {
    @Autowired
    private TransactionRepo transactionRepo;

    public TransactionModel addToDB(TransactionRequest data,double creditPartyBalence,double debitPartyBalence) {
        log.info("Going to add in DB");

        TransactionModel transactionModel = TransactionModel.builder()
                .transactionAmount(data.getTransactionAmount())
                .transactionMode(data.getTransactionMode())
                .creditParty(data.getCreditParty())
                .creditPartyBalance(creditPartyBalence+data.getTransactionAmount())
                .debitParty(data.getDebitParty())
                .billDetails(data.getBillDetails())
                .debitPartyBalance(debitPartyBalence-data.getTransactionAmount())
                .transactionDate(new Date()).build();
        log.info(transactionModel.toString());
        transactionRepo.save(transactionModel);
//        log.info("-------- Data from DB --------");
        return transactionModel;
    }


    public List<TransactionResponse> getCreditedTransactions(String accountNumber){
        return transactionRepo.findItemByCreditParty(accountNumber).stream()
                .sorted(Comparator.comparing(TransactionModel::getTransactionDate))
                .map(a->{
                    return TransactionResponse.builder()
                            .description(a.getTransactionId()+" / "+a.getDebitParty())
                            .amountDeposit(a.getTransactionAmount())
                            .transactionMode(a.getTransactionMode())
                            .balanceAmount(a.getCreditPartyBalance())
                            .transactionDate(a.getTransactionDate()).build();
                })
                .collect(Collectors.toList());
    }
    public List<TransactionResponse> getDebitedTransactions(String accountNumber){
        return transactionRepo.findItemByDebitParty(accountNumber).stream()
                .sorted(Comparator.comparing(TransactionModel::getTransactionDate))
                .map(a->{
                    return TransactionResponse.builder()
                            .description(a.getTransactionId()+" / "+a.getCreditParty()+" " + (a.getBillDetails()==null?"":"/ "+a.getBillDetails()))
                            .amountWithdraw(a.getTransactionAmount())
                            .transactionMode(a.getTransactionMode())
                            .balanceAmount(a.getDebitPartyBalance())
                            .transactionDate(a.getTransactionDate()).build();
                })
                .collect(Collectors.toList());
    }
}

