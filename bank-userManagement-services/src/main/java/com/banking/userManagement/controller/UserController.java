package com.banking.userManagement.controller;

import com.banking.userManagement.model.UserModel;
import com.banking.userManagement.repo.userRepoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private userRepoImp userRepoImp;

    @GetMapping("/get")
    public UserModel users(){
       return userRepoImp.users();
    }
}
