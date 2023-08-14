package com.banking.loans.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document(collection = "loan")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanModel {
    @Id
    private String id;
    private int numberOfMonth;
    private double EMIAmount;
    private double totalAmount;
    private float interest;
    private String ACno;
    private String status;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date date;
    private String typeOfLoan;
}
