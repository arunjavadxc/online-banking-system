package com.banking.userManagement.services;

import com.banking.userManagement.dto.AddUserResponse;
import com.banking.userManagement.dto.UserRequest;
import com.banking.userManagement.exceptions.UserNotFoundException;
import com.banking.userManagement.model.UserModel;
import com.banking.userManagement.repo.userRepoImp;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
@Slf4j
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
                    else return findUser(a).getBalance();
                }));
    }

    @Override
    public Integer updateBalance(Map<String, Double> balance) {
        return userRepo.updateBalance(balance);
    }
}
