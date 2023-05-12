package com.banking.user.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.user.entity.User;
import com.banking.user.exception.NotFoundException;
import com.banking.user.model.request.UserSaveRequestDTO;
import com.banking.user.repository.UserRepository;
import com.banking.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public User saveUser(UserSaveRequestDTO user) {
		User userEntity = new User();
		return userRepo.save(userEntity);
	}

	@Override
	public void deleteUser(long userID) {
		userRepo.deleteById(userID);

	}

	@Override
	public User findByUserID(long userID) {
		Optional<User> user = userRepo.findById(userID);

		if (user.isEmpty()) {
			throw new NotFoundException(String.format("User id: %s not found", userID));
		}

		return user.get();
	}

	@Override
	public User findByEmailID(String emailID) {
		return userRepo.findByEmailID(emailID);
	}

}
