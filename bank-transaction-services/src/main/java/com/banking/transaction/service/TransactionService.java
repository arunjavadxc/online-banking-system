package com.banking.transaction.service;

import com.banking.transaction.dto.TransactionRequest;
import com.banking.transaction.dto.TransactionResponse;
import com.banking.transaction.repo.TransactionImp;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class TransactionService {
    @Autowired
    private TransactionImp transaction;

    public void addDataToDB(TransactionRequest data)
    {
        log.info("Entered into Service layer");
        transaction.addDataToDB(data);
    }

    public List<TransactionResponse> getAllTransactions(String accountNumber) {
        return transaction.getAllTransactions(accountNumber);
    }
}
