package com.bank.ui.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.ui.dto.UserDTO;
import com.bank.ui.utils.Constants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = Constants.API_PREFIX_V1)
public class UserController {

	@GetMapping("/user/dtls")
	public UserDTO getUserDetails() {
		log.info("Entry into method getUserDetails() ");

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		UserDTO userDTO = new UserDTO();
		userDTO.setFirstName(auth.getName());

		return userDTO;
	}

}
