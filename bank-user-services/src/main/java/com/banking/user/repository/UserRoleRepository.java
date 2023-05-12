package com.banking.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.user.entity.UserRoles;

public interface UserRoleRepository extends JpaRepository<UserRoles, Long> {

}
