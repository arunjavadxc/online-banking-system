package com.banking.user.entity;

import java.time.LocalDate;

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
	private long creditcardId;
	private String creditcardNumber;
	private String creditcardOwner;
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
