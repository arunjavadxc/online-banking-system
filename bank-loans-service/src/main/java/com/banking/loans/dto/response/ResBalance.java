package com.banking.loans.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResBalance {
    private String accountNumber;
    private double DueAmount;
}
