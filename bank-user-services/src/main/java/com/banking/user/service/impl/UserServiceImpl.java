package com.banking.user.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.user.entity.User;
import com.banking.user.entity.UserAccount;
import com.banking.user.exception.NotFoundException;
import com.banking.user.exception.UserAlreadyExistException;
import com.banking.user.mapper.UserRequestMapperImpl;
import com.banking.user.model.request.UserSaveRequestDTO;
import com.banking.user.repository.UserAccountRepository;
import com.banking.user.repository.UserRepository;
import com.banking.user.service.UserService;
import com.banking.user.utils.Constants;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private UserAccountRepository userAccountRepository;

	private UserRequestMapperImpl userRequestMapperImpl = new UserRequestMapperImpl();

	@Override
	public User saveUser(UserSaveRequestDTO userReqDTO) {

		if (userRepo.findByEmailID(userReqDTO.getEmailID()) != null) {
			throw new UserAlreadyExistException(
					String.format("Email ID :%s is already registered.", userReqDTO.getEmailID()));
		}

		User userEntity = userRequestMapperImpl.userReqDTOToUser(userReqDTO);

		User savedUser = userRepo.save(userEntity);

		UserAccount userAccount = new UserAccount();
		userAccount.setAccountNumber("5001" + savedUser.getUserID());
		userAccount.setBalance(0.0f);
		userAccount.setBranch("CHENNAI");
		userAccount.setIfsc(Constants.IFSC_CODE);
		userAccount.setUser(savedUser);
		
		userAccountRepository.save(userAccount);

		return savedUser;
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
