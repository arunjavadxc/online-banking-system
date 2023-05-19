package com.banking.transaction.model;

import com.banking.transaction.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.OffsetDateTime;
import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection="TransactionModule")
public class TransactionModel {
    @Id
    private String transactionId;
    private double transactionAmount;
    private String transactionMode;
    private String creditParty;
    private String debitParty;
    private TransactionType transactionType;
    private OffsetDateTime transactionDate;
}
