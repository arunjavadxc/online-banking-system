package com.banking.usermanagement.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.usermanagement.dto.AddUserResponse;
import com.banking.usermanagement.dto.UserRequest;
import com.banking.usermanagement.exceptions.UserNotFoundException;
import com.banking.usermanagement.model.UserModel;
import com.banking.usermanagement.repo.UserRepoImp;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class UserServiceImp implements UserService{
    @Autowired
    private UserRepoImp userRepo;
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
        UserModel userDetails = userRepo.users(accountNumber);
        if (userDetails==null)
            throw new UserNotFoundException("This " + accountNumber + " Account Number is not valid");
        return userDetails;
    }

    @Override
    @SneakyThrows
    public Map<String,Double> currentBalance(List<String> accountNumbers) {
       return accountNumbers.stream()
                .collect(Collectors.toMap(a->a,a-> {
                    if (findUser(a) == null)
                            throw new UserNotFoundException("This " + a + " Account Number is not valid");
                    else return this.findUser(a).getBalance();
                }));
    }

    @Override
    public Integer updateBalance(Map<String, Double> balance) {
        return userRepo.updateBalance(balance);
    }

    @Override
    public Integer deleteUser(String accountNumber) {
        return userRepo.deleteUser(accountNumber);

    }
}
