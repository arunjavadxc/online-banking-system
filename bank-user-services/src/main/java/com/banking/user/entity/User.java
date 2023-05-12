package com.banking.user.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "m_user_dtls")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5509869373313882058L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long userID;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email_id")
	private String emailID;

	@Column(name = "password_v")
	private String password;

	@Column(name = "user_status")
	private boolean userStatus;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "mp_user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<UserRoles> userRoles;
}
