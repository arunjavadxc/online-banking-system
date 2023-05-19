package com.banking.transaction.repo;

import com.banking.transaction.enums.TransactionType;
import com.banking.transaction.model.TransactionModel;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.time.ZonedDateTime;

@Repository
@Log4j2
public class TransactionImp {
    @Autowired
    private TransactionRepo transactionRepo;


    public Boolean addDataToDB(){
        log.info("Going to add in DB");
        log.info("current date and time : {}",OffsetDateTime.now());
        TransactionModel transactionModel = TransactionModel.builder().transactionAmount(5000.45)
                .transactionMode("IMPS")
                .creditParty("1234").debitParty("5678")
                .transactionType(TransactionType.DEBIT)
                        .transactionDate(OffsetDateTime.now()).build();


        log.info(transactionModel);
        transactionRepo.save(transactionModel);
        log.info("-------- Data from DB --------");
        transactionRepo.findAll().stream().forEach(log::info);
        return true;
    }
}
