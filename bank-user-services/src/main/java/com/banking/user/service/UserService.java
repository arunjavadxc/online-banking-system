package com.banking.user.service;

import com.banking.user.entity.User;
import com.banking.user.model.request.UserSaveRequestDTO;

public interface UserService {

	User saveUser(UserSaveRequestDTO user);

	void deleteUser(long userID);

	User findByUserID(long userID);

	User findByEmailID(String emailID);

}
