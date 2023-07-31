package com.banking.usermanagement.services;

import java.util.List;
import java.util.Map;

import com.banking.usermanagement.dto.AddUserResponse;
import com.banking.usermanagement.dto.UserRequest;
import com.banking.usermanagement.model.UserModel;


public interface UserService {
    AddUserResponse addUser(UserRequest user);

    UserModel findUser(String accountNumber);

    Map<String,Double> currentBalance(List<String> accountNumbers);

    Integer updateBalance(Map<String,Double> balance);

    Integer deleteUser(String accountNumber);
}
