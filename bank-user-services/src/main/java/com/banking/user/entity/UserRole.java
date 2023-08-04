//package com.banking.user.entity;
//
//import java.io.Serializable;
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.ManyToMany;
//import javax.persistence.Table;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//
//@Data
//@Entity
//@Table(name = "m_user_roles")
//@EqualsAndHashCode(exclude = { "users" })
//public class UserRole implements Serializable {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 8731371823759833543L;
//
//	@Id
//	@Column(name = "role_id")
//	private int id;
//
//	@Column(name = "role_name")
//	private String roleName;
//
//	@ManyToMany(mappedBy = "userRoles")
//	@JsonIgnore
//	private Set<User> users = new HashSet<>();
//
//}
