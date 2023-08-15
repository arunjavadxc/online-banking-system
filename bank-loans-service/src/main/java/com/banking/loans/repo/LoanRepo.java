package com.banking.loans.repo;

import com.banking.loans.model.LoanModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;

public interface LoanRepo extends MongoRepository<LoanModel,String> {


    @Query(value = "{'ACno': ?0}")
    public List<LoanModel> findDateByACno(String accountNumber);
}
