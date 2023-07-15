package com.banking.user.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "credit_card")
public class CreditCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "creditcard_id")
	private long creditcardId;
	
	@Column(name = "creditcard_number")
	private String creditcardNumber;
	
	@Column(name = "creditcard_owner")
	private String creditcardOwner;
	
	@Column(name = "expiration_date")
	private LocalDate expirationDate;
	
	public long getCreditcardId() {
		return creditcardId;
	}
	public void setCreditcardId(long creditcardId) {
		this.creditcardId = creditcardId;
	}
	public String getCreditcardNumber() {
		return creditcardNumber;
	}
	public void setCreditcardNumber(String creditcardNumber) {
		this.creditcardNumber = creditcardNumber;
	}
	public String getCreditcardOwner() {
		return creditcardOwner;
	}
	public void setCreditcardOwner(String creditcardOwner) {
		this.creditcardOwner = creditcardOwner;
	}
	public LocalDate getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}
}
