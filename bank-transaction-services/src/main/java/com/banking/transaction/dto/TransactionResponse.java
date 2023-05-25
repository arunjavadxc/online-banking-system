package com.banking.transaction.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Builder
@Data
public class TransactionResponse {
    private double amountWithdraw;
    private double amountDeposit;
    private double balanceAmount;
    private String transactionMode;
    private String description;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date transactionDate;
}
