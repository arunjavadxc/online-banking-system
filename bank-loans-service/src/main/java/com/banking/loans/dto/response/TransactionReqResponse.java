package com.banking.loans.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionReqResponse {
    private double transactionAmount;
    private double balance;
    private String receiver;
}
