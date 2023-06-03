package com.banking.userManagement.services;

import com.banking.userManagement.dto.AddUserResponse;
import com.banking.userManagement.dto.UserRequest;
import com.banking.userManagement.model.UserModel;
import com.banking.userManagement.repo.userRepoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService{
    @Autowired
    private userRepoImp userRepo;
    @Override
    public AddUserResponse addUser(UserRequest user) {
       UserModel User = userRepo.addUser(user);
       return AddUserResponse.builder()
               .accountNumber(User.getAccountNumber())
               .name(User.getName())
               .build();
    }

    @Override
    public UserModel findUser(String accountNumber) {
        return userRepo.users(accountNumber);
    }

    @Override
    public Map<String,Double> currentBalance(List<String> accountNumbers) {
        return accountNumbers.stream()
                .collect(Collectors.toMap(a->a,a->findUser(a).getBalance()));
    }
}
