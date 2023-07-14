package com.banking.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "loan")
public class Loan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "loan_id")
	private long loanId;
	
	@Column(name = "customer_name")
	private String customerName;
	
	@Column(name = "loan_amount")
	private double loanAmount;
	
	@Column(name = "duration")
	private int duration;
	
	@Column(name = "monthly_emi")
	private double monthlyEMI;
	
	@Column(name = "interest_rate")
	private double interestRate;
	
	public long getLoanId() {
		return loanId;
	}
	public void setLoanId(long loanId) {
		this.loanId = loanId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public double getMonthlyEMI() {
		return monthlyEMI;
	}
	public void setMonthlyEMI(double monthlyEMI) {
		this.monthlyEMI = monthlyEMI;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
}
