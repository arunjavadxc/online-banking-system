package com.banking.user.entity;

import java.time.LocalDate;

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
@Table(name = "credit_card")
public class CreditCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long creditcardId;
	private String creditcardNumber;
	private String creditcardOwner;
	private LocalDate expirationDate;
}
