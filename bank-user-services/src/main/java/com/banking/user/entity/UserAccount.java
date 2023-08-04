package com.banking.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "m_user_ac")
@EqualsAndHashCode(exclude = { "user" })
public class UserAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "m_user_ac_seq")
	@SequenceGenerator(name = "m_user_seq_gen", sequenceName = "m_user_ac_seq", initialValue = 10010101, allocationSize = 1)
	@Column(name = "user_ac")
	private long id;
	private String accountNumber;
	private String branch;
	private String ifsc;
	private String name;
	private double balance;

	@OneToOne
	@JoinColumn(name = "user_id")
    @JsonBackReference
	private User user;

}
