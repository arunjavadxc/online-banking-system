package com.bank.ui.controller;

import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.ui.Model;
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
		System.out.println(auth.toString());
		UserDTO userDTO = new UserDTO();
		userDTO.setFirstName(auth.getName());

		return userDTO;
	}

	@GetMapping(path = "/users")
	public String getUserInfo() {

		final DefaultOidcUser user = (DefaultOidcUser) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();

		String userID = "";

		OidcIdToken token = user.getIdToken();

		Map<String, Object> customClaims = token.getClaims();

		if (customClaims.containsKey("user_id")) {
			userID = String.valueOf(customClaims.get("user_id"));
		}
		return userID;
	}

}
