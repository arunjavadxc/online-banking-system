package com.banking.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmailID(String emailID);

}
