package com.banking.transaction.service;

import com.banking.transaction.repo.TransactionImp;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class TransactionService {
    @Autowired
    private TransactionImp transaction;

    public void addDataToDB()
    {
        log.info("Entered into Service layer");
        transaction.addDataToDB();
    }
}
