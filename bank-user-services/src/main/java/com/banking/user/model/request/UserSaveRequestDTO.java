package com.banking.user.model.request;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.banking.user.entity.UserRoles;

import lombok.Data;

@Data
public class UserSaveRequestDTO {

	@NotEmpty
	private String firstName;
	private String middleName;
	@NotEmpty
	private String lastName;
	@NotEmpty
	private String emailID;
	@NotEmpty
	private String password;

	private boolean userStatus;

	private List<UserRoles> userRoles;

}
