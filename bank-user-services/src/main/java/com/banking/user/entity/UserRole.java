package com.banking.user.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "m_user_roles")
public class UserRole implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8731371823759833543L;

	@Id
	@Column(name = "role_id")
	private int id;

	@Column(name = "role_name")
	private String roleName;

//	@ManyToMany(mappedBy = "userRoles")
//	@JsonIgnoreProperties
//	private Set<User> users = new HashSet<>();

}
