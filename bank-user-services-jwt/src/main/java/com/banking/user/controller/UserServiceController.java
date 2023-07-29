package com.banking.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.user.utils.Constants;

@RequestMapping(path = Constants.API_PREFIX_V1)
@RestController
public class UserServiceController {

	@GetMapping("/testUser")
	public String testRest() {
		return "User Service Running";
	}

}
