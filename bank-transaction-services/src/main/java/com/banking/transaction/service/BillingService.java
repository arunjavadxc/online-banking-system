package com.banking.transaction.service;

import com.banking.transaction.dto.BillRequest;
import com.banking.transaction.model.BillingModel;

public interface BillingService {

    String PayBill(BillRequest request);

    BillingModel addBill(BillingModel request);

}
