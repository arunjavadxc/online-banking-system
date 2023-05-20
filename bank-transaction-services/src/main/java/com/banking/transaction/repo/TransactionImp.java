package com.banking.transaction.repo;

import com.banking.transaction.dto.TransactionRequest;
import com.banking.transaction.dto.TransactionResponse;
import com.banking.transaction.model.TransactionModel;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
@Log4j2
public class TransactionImp {
    @Autowired
    private TransactionRepo transactionRepo;

    public Boolean addDataToDB(TransactionRequest data){
        log.info("Going to add in DB");
        TransactionModel transactionModel = TransactionModel.builder()
                .transactionAmount(data.getTransactionAmount())
                .transactionMode(data.getTransactionMode())
                .creditParty(data.getCreditParty())
                .debitParty(data.getDebitParty())
                .transactionDate(new Date()).build();
        log.info(transactionModel);
        transactionRepo.save(transactionModel);
//        log.info("-------- Data from DB --------");
        return true;
    }

    public List<TransactionResponse> getAllTransactions(String accountNumber) {
        List<TransactionResponse> credit = getCreditedTransactions(accountNumber);
        List<TransactionResponse> debit = getDebitedTransactions(accountNumber);
        List<TransactionResponse> allTransactions = Stream.concat(credit.stream(),debit.stream()).collect(Collectors.toList());
        return allTransactions.stream().sorted(Comparator.comparing(TransactionResponse::getTransactionDate)).collect(Collectors.toList());

    }

    public List<TransactionResponse> getCreditedTransactions(String accountNumber){
        return transactionRepo.findItemByCreditParty(accountNumber).stream()
                .sorted(Comparator.comparing(TransactionModel::getTransactionDate))
                .map(a->{
                    return TransactionResponse.builder()
                            .description(a.getTransactionId()+" / "+a.getDebitParty())
                            .amountDeposit(a.getTransactionAmount())
                            .transactionMode(a.getTransactionMode())
                            .transactionDate(a.getTransactionDate()).build();
                })
                .collect(Collectors.toList());
    }
    public List<TransactionResponse> getDebitedTransactions(String accountNumber){
        return transactionRepo.findItemByDebitParty(accountNumber).stream()
                .sorted(Comparator.comparing(TransactionModel::getTransactionDate))
                .map(a->{
                    return TransactionResponse.builder()
                            .description(a.getTransactionId()+" / "+a.getCreditParty()+a.getBillDetails())
                            .amountWithdraw(a.getTransactionAmount())
                            .transactionMode(a.getTransactionMode())
                            .transactionDate(a.getTransactionDate()).build();
                })
                .collect(Collectors.toList());
    }
}

