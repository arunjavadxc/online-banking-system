package com.banking.user.service;

import com.banking.user.entity.User;

public interface UserService {

	User saveUser(User user);

	void deleteUser(long userID);

	User findByUserID(long userID);

	User findByEmailID(String emailID);

}
