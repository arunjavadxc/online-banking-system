package com.banking.user.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

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


}
