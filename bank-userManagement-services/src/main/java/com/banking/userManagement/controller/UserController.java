package com.banking.userManagement.controller;

import com.banking.userManagement.dto.AddUserResponse;
import com.banking.userManagement.dto.UserRequest;
import com.banking.userManagement.model.UserModel;
import com.banking.userManagement.services.UserService;
import com.banking.userManagement.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping(path = Constants.API_PREFIX_V1)
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/User/{accountNumber}")
    public UserModel users(@PathVariable String accountNumber){
       return userService.findUser(accountNumber);
    }

    @GetMapping("/User/balance/{accountNumbers}")
    public Map<String,Double> balanceOfUsers(@PathVariable List<String> accountNumbers)
    {
        return userService.currentBalance(accountNumbers);
    }
    @PostMapping("/User")
    public AddUserResponse addUser(@RequestBody UserRequest user){
       return userService.addUser(user);
    }

    @PostMapping("/User/balance")
    public Map<String,Double> updateBalance(@RequestBody Map<String,Double> user)
    {
        log.info(user.toString());
        return user;
    }
}
