package com.banking.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.user.entity.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

}
