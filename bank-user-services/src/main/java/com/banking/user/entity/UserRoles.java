package com.banking.user.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "m_user_roles")
public class UserRoles implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8731371823759833543L;

	@Id
	@Column(name = "role_id")
	private int id;

	@Column(name = "role_name")
	private String roleName;

}
