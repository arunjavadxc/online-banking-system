package com.banking.transaction.service;

import com.banking.transaction.dto.TransactionReqResponse;
import com.banking.transaction.dto.TransactionRequest;
import com.banking.transaction.dto.TransactionResponse;
import com.banking.transaction.model.TransactionModel;

import java.util.List;

public interface TransactionService {
    TransactionReqResponse addTransacrtion(TransactionRequest data);

    public List<TransactionResponse> getAllTransactions(String accountNumber);

}
