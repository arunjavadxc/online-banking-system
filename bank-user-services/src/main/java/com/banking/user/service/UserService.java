package com.banking.user.service;

import java.util.List;
import java.util.Map;

import com.banking.user.entity.User;
import com.banking.user.entity.UserAccount;
import com.banking.user.model.request.UserSaveRequestDTO;

public interface UserService {

	User saveUser(UserSaveRequestDTO user);

	void deleteUser(long userID);

	User findByUserID(long userID);

	User findByEmailID(String emailID);

	UserAccount findUserByAccNumber(String accountNumber);

	Map<String, Double> currentBalance(List<String> accountNumbers);

	Integer updateBalance(Map<String, Double> balance);

}
