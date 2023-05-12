package com.banking.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.user.entity.User;
import com.banking.user.service.UserService;
import com.banking.user.utils.Constants;

@RequestMapping(path = Constants.USER_API_PREFIX)
@RestController
public class UserServiceController {

	@Autowired
	private UserService userService;

	@GetMapping("/{userID}")
	public User getUserByUserID(@PathVariable long userID) {
		return userService.findByUserID(userID);
	}

}
