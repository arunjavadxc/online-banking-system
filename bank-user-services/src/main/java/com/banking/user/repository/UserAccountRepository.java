package com.banking.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.banking.user.entity.UserAccount;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

	@Query("From UserAccount where accountNumber = :accountNumber")
	public UserAccount findByAccountNumber(String accountNumber);

}
