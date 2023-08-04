package com.bank.ui.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.ui.dto.UserDTO;
import com.bank.ui.utils.Constants;
import com.bank.ui.utils.Response;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = Constants.API_PREFIX_V1)
public class UserController {

	@GetMapping("/user/dtls")
	public ResponseEntity<Response<UserDTO>> getUserDetails() {
		log.info("Entry into method getUserDetails() ");
		final DefaultOidcUser user = (DefaultOidcUser) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		OidcIdToken token = user.getIdToken();

		UserDTO userDTO = new UserDTO();
		Map<String, Object> customClaims = token.getClaims();

		if (customClaims.containsKey("user_id")) {
			userDTO.setUserID(String.valueOf(customClaims.get("user_id")));
		}

		if (customClaims.containsKey("given_name")) {
			userDTO.setFirstName(String.valueOf(customClaims.get("given_name")));
		}

		if (customClaims.containsKey("family_name")) {
			userDTO.setLastName(String.valueOf(customClaims.get("family_name")));
		}

		if (customClaims.containsKey("email")) {
			userDTO.setEmailID(String.valueOf(customClaims.get("email")));
		}

		return ResponseEntity.ok(new Response<UserDTO>(200, "Success", userDTO));
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
