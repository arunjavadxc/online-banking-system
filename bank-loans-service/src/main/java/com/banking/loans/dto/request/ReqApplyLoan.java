package com.banking.loans.dto.request;

import lombok.Data;

@Data
public class ReqApplyLoan {
    private int numberOfMonth;
    private String accountNo;
    private String typeOfLoan;
    private double amount;
}
