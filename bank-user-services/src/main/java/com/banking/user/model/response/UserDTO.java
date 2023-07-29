package com.banking.user.model.response;

import java.util.HashSet;
import java.util.Set;

import com.banking.user.entity.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
public class UserDTO {

	private long userID;

	private String firstName;

	private String middleName;

	private String lastName;

	private String emailID;

	@JsonIgnore
	private String password;

	private boolean userStatus;

	@JsonIgnoreProperties("users")
	private Set<UserRole> userRoles = new HashSet<>();

}
