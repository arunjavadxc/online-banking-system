package com.banking.user.controller;

import java.util.List;
import java.util.Map;

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
import com.banking.user.entity.UserAccount;
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
	public ResponseEntity<Response<User>> getUserByUserID(@PathVariable long userID) {
		Response<User> response = new Response<>(200, "Success", userService.findByUserID(userID));
		return ResponseEntity.ok(response);
	}

	@PostMapping("/save")
	public ResponseEntity<Response<UserDTO>> saveUser(@Valid @RequestBody UserSaveRequestDTO user) {
		Response<UserDTO> response = new Response<>(HttpStatus.CREATED.value(), "Created",
				userRequestMapperImpl.userTOUserDTO(userService.saveUser(user)));
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@PostMapping("/balance/multiple")
	public Map<String, Double> balanceOfUsers(@RequestBody List<String> accountNumbers) {
		return userService.currentBalance(accountNumbers);
	}

	@GetMapping("/balance/{accountNumber}")
	public UserAccount users(@PathVariable String accountNumber) {
		return userService.findUserByAccNumber(accountNumber);
	}

	@PostMapping("/users/balance")
	public ResponseEntity updateBalance(@RequestBody Map<String, Double> user) {

		return ResponseEntity.status(HttpStatus.CREATED).body(userService.updateBalance(user));
	}

}
