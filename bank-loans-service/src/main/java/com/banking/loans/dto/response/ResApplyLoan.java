package com.banking.loans.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResApplyLoan {
    private int numberOfMonth;
    private double EMIAmount;
    private double totalAmount;
    private float interest;
    private String typeOfLoan;
}
