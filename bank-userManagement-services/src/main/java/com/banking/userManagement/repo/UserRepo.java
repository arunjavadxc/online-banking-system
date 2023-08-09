package com.banking.usermanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.banking.usermanagement.model.UserModel;

@Repository
public interface UserRepo extends JpaRepository<UserModel, String> {

	public UserModel findByaccountNumber(String accountNumber);

	@Modifying
	@Query("UPDATE UserModel u SET u.balance = ?1 WHERE u.accountNumber = ?2")
	Integer updateBalance(double balance, String accountNumber);

	Integer deleteByaccountNumber(String accountNumber);
}
