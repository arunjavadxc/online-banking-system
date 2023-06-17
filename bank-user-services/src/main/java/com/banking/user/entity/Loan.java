package com.banking.user.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "loan")
public class Loan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long loanId;
	private String customerName;
	private double loanAmount;
	private int duration;
	private double monthlyEMI;
	private double interestRate;
}
