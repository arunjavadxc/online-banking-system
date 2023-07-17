package com.banking.transaction.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(value="BillBD")
public class BillingModel {
    @Id
    private int serviceNumber;
    private String companyName;
    private String companyAccountNumber;
    private double amount;
}
