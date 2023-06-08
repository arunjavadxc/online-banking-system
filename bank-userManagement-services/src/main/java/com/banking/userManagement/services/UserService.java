package com.banking.userManagement.services;

import com.banking.userManagement.dto.AddUserResponse;
import com.banking.userManagement.dto.UserRequest;
import com.banking.userManagement.model.UserModel;


import java.util.List;
import java.util.Map;


public interface UserService {
    AddUserResponse addUser(UserRequest user);

    UserModel findUser(String accountNumber);

    Map<String,Double> currentBalance(List<String> accountNumbers);

    Integer updateBalance(Map<String,Double> balance);
}
