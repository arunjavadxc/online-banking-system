package com.banking.transaction.repo;

import com.banking.transaction.model.BillingModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BillingRepo extends MongoRepository<BillingModel,Integer> {

}
