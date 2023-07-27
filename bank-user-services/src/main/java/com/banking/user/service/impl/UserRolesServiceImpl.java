package com.banking.user.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.user.entity.UserRole;
import com.banking.user.exception.NotFoundException;
import com.banking.user.repository.UserRoleRepository;
import com.banking.user.service.UserRoleService;

@Service
public class UserRolesServiceImpl implements UserRoleService {

	@Autowired
	private UserRoleRepository userRoleRepository;

	public UserRole getUserRoleBsdOnID(int roleID) {
		Optional<UserRole> userRole = userRoleRepository.findById(roleID);

		if (userRole.isEmpty()) {
			throw new NotFoundException(String.format("User Role %s not found", roleID));
		}

		return userRole.get();
	}

}
