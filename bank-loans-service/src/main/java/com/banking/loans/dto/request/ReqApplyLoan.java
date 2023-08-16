package com.banking.loans.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqApplyLoan {
    private int numberOfMonth;
    private String accountNo;
    private String typeOfLoan;
    private double amount;
}
