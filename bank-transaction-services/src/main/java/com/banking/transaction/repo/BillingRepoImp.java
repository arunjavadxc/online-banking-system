package com.banking.transaction.repo;

import com.banking.transaction.model.BillingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class BillingRepoImp {
    @Autowired
    private BillingRepo billingRepo;

    public BillingModel getBillingRepo(Integer serviceNumber) {
        return billingRepo.findById(serviceNumber).get();
    }

    public BillingModel setBillingRepo(BillingModel billingModel) {
        System.out.println(billingModel);
        return  billingRepo.save(billingModel);
    }
}
