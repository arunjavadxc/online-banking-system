package com.banking.user.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.user.entity.User;
import com.banking.user.mapper.UserRequestMapperImpl;
import com.banking.user.model.request.UserSaveRequestDTO;
import com.banking.user.model.response.UserDTO;
import com.banking.user.service.UserService;
import com.banking.user.utils.Constants;
import com.banking.user.utils.Response;

@RequestMapping(path = Constants.USER_API_PREFIX)
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	private UserRequestMapperImpl userRequestMapperImpl = new UserRequestMapperImpl();

	@GetMapping("/{userID}")
	public User getUserByUserID(@PathVariable long userID) {
		return userService.findByUserID(userID);
	}

	@PostMapping("/save")
	public ResponseEntity<Response<UserDTO>> saveUser(@Valid @RequestBody UserSaveRequestDTO user) {
		Response<UserDTO> response = new Response<>(HttpStatus.CREATED.value(), "Created",
				userRequestMapperImpl.userTOUserDTO(userService.saveUser(user)));

		return new ResponseEntity<>(response, HttpStatus.CREATED);

	}
}
