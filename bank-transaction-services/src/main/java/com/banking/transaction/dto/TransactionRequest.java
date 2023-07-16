package com.banking.transaction.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionRequest {
    private String creditParty;
    private String debitParty;
    private double transactionAmount;
    private String transactionMode;
    private String billDetails;
}
