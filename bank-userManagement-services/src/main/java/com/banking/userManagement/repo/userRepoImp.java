package com.banking.userManagement.repo;

import com.banking.userManagement.dto.UserRequest;
import com.banking.userManagement.model.UserModel;
import com.banking.userManagement.utils.AccountNumberGenerator;
import com.banking.userManagement.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;


@Repository
@Slf4j
public class userRepoImp {

    @Autowired
    private userRepo userRepo;

    public UserModel users(String accountNumber){

        return userRepo.findByaccountNumber(accountNumber);
    }

    public UserModel addUser(UserRequest user) {
        UserModel User = UserModel.builder()
                .ifsc(Constants.IFSC)
                .balance(0)
                .branch(Constants.BRANCH)
                .name(user.getName())
                .emailId(user.getEmailId())
                .number(user.getNumber())
                .accountNumber(AccountNumberGenerator.randomGenerator())
                .address(user.getAddress())
                .build();
        userRepo.save(User);
        return User;
    }
    @Transactional
    public Integer updateBalance(Map<String,Double> balance){
        int numberOfAccountsUpdated=0;
        for(Map.Entry<String,Double> bal:balance.entrySet()){
            numberOfAccountsUpdated+= userRepo.updateBalance(bal.getValue(),bal.getKey());
        }
        return numberOfAccountsUpdated;
    }
    @Transactional
    public Integer deleteUser(String accountNumber) {
       return userRepo.deleteByaccountNumber(accountNumber);

    }
}
