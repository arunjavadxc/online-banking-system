package com.banking.usermanagement.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.usermanagement.dto.AddUserResponse;
import com.banking.usermanagement.dto.UserRequest;
import com.banking.usermanagement.model.UserModel;
import com.banking.usermanagement.services.UserService;
import com.banking.usermanagement.utils.Constants;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(path = Constants.API_PREFIX_V1)
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/users/{accountNumber}")
    public UserModel users(@PathVariable String accountNumber){
       return userService.findUser(accountNumber);
    }

    @GetMapping("/users/balance/{accountNumbers}")
    public Map<String,Double> balanceOfUsers(@PathVariable List<String> accountNumbers)
    {
        return userService.currentBalance(accountNumbers);
    }
    @PostMapping("/users")
    public AddUserResponse addUser(@RequestBody UserRequest user){
       return userService.addUser(user);
    }

    @PostMapping("/users/balance")
    public ResponseEntity updateBalance(@RequestBody Map<String,Double> user)
    {
        for(Map.Entry<String,Double> User:user.entrySet()) {
            log.info("Key = {}, Value = {}", User.getKey(), User.getValue());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.updateBalance(user));
    }
    @DeleteMapping("/users/{accountNumber}")
    public Integer deleteUser(@PathVariable String accountNumber){
        return userService.deleteUser(accountNumber);
    }
}
