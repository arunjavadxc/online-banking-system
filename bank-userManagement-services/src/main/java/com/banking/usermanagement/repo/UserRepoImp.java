package com.banking.usermanagement.repo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.banking.usermanagement.dto.UserRequest;
import com.banking.usermanagement.model.UserModel;
import com.banking.usermanagement.utils.AccountNumberGenerator;
import com.banking.usermanagement.utils.Constants;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class UserRepoImp {

	@Autowired
	private UserRepo userRepo;

	public UserModel users(String accountNumber) {

		return userRepo.findByaccountNumber(accountNumber);
	}

	public UserModel addUser(UserRequest user) {
		UserModel User = UserModel.builder().ifsc(Constants.IFSC).balance(0).branch(Constants.BRANCH)
				.name(user.getName()).emailId(user.getEmailId()).number(user.getNumber())
				.accountNumber(AccountNumberGenerator.randomGenerator()).address(user.getAddress()).build();
		userRepo.save(User);
		return User;
	}

	@Transactional
	public Integer updateBalance(Map<String, Double> balance) {
		int numberOfAccountsUpdated = 0;
		for (Map.Entry<String, Double> bal : balance.entrySet()) {
			numberOfAccountsUpdated += userRepo.updateBalance(bal.getValue(), bal.getKey());
		}
		return numberOfAccountsUpdated;
	}

	@Transactional
	public Integer deleteUser(String accountNumber) {
		return userRepo.deleteByaccountNumber(accountNumber);

	}
}
