package com.banking.user.model.request;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class UserSaveRequestDTO {

//	@NotEmpty
	private String firstName;
	private String middleName;
//	@NotEmpty
	private String lastName;
	@NotEmpty
	private String emailID;
	@NotEmpty
	private String password;

	private boolean userStatus = true;

}
