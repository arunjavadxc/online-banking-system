package com.banking.transaction.repo;

import com.banking.transaction.model.TransactionModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TransactionRepo extends MongoRepository<TransactionModel, String> {
    @Query("{creditParty:'?0'}")
    List<TransactionModel> findItemByCreditParty(String creditParty);

    @Query("{debitParty:'?0'}")
    List<TransactionModel> findItemByDebitParty(String debitParty);
}
