package com.banking.transaction.service;

import com.banking.transaction.dto.BillRequest;
import com.banking.transaction.dto.TransactionReqResponse;
import com.banking.transaction.dto.TransactionRequest;
import com.banking.transaction.model.BillingModel;
import com.banking.transaction.repo.BillingRepoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class BillingServiceImp implements BillingService{

    @Autowired
    private BillingRepoImp  billingRepo;
    @Autowired
    private TransactionService transactionService;
    @Override
    public String PayBill(BillRequest request) {
        try {
            BillingModel billDetails = billingRepo.getBillingRepo(request.getServiceNumber());
            TransactionRequest transasction = TransactionRequest.builder().transactionAmount(billDetails.getAmount())
                    .billDetails(billDetails.getCompanyName())
                    .creditParty(billDetails.getCompanyAccountNumber())
                    .debitParty(request.getCustomerAN()).build();
            TransactionReqResponse TrancactionDetails = transactionService.addTransacrtion(transasction);
            return "Success";
        }
        catch (NoSuchElementException e)
        {
            return "Failed";
        }
    }

    @Override
    public BillingModel addBill(BillingModel request) {
        return billingRepo.setBillingRepo(request);

    }
}
