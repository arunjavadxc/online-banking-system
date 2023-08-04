package com.banking.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.banking.user.entity.UserAccount;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

	@Query("From UserAccount where accountNumber = :accountNumber")
	public UserAccount findByAccountNumber(String accountNumber);

	@Modifying
	@Query("UPDATE UserAccount u SET u.balance = ?1 WHERE u.accountNumber = ?2")
	Integer updateBalance(double balance, String accountNumber);

}
