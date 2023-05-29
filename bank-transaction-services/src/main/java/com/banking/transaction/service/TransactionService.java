package com.banking.transaction.service;

import com.banking.transaction.Exceptions.InsufficientBalance;
import com.banking.transaction.dto.TransactionReqResponse;
import com.banking.transaction.dto.TransactionRequest;
import com.banking.transaction.dto.TransactionResponse;
import com.banking.transaction.model.TransactionModel;
import com.banking.transaction.repo.TransactionImp;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Log4j2
public class TransactionService{
    @Autowired
    private TransactionImp transaction;

    public TransactionReqResponse addTransacrtion(TransactionRequest data){
        log.info("Entered into Service layer");
        //check users are present and get balance from them and transfer to addDataToDB
        double creditPartyBalance = 10000;
        double debitPartyBalance = 10000;
        TransactionModel transResponse = addDataToDB(data, creditPartyBalance, debitPartyBalance);
        //update current balance
        return TransactionReqResponse.builder().transactionAmount(transResponse.getTransactionAmount())
                .balance(transResponse.getDebitPartyBalance())
                .receiver(transResponse.getCreditParty()).build();
    }
    @SneakyThrows
    public TransactionModel addDataToDB(TransactionRequest data, double creditPartyBalance, double debitPartyBalance){

        if(debitPartyBalance<data.getTransactionAmount())
            throw new InsufficientBalance(data.getDebitParty()+" You don't have sufficient balance");
        return transaction.addToDB(data, creditPartyBalance, debitPartyBalance);
    }

    public List<TransactionResponse> getAllTransactions(String accountNumber) {
        List<TransactionResponse> credit = transaction.getCreditedTransactions(accountNumber);
        List<TransactionResponse> debit = transaction.getDebitedTransactions(accountNumber);
        List<TransactionResponse> allTransactions = Stream.concat(credit.stream(),debit.stream()).collect(Collectors.toList());
        return allTransactions.stream()
                .sorted(Comparator.comparing(TransactionResponse::getTransactionDate))
                .collect(Collectors.toList());
    }
}
