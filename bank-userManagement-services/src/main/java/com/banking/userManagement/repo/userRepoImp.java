package com.banking.userManagement.repo;

import com.banking.userManagement.model.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Slf4j
public class userRepoImp {

    @Autowired
    private userRepo userRepo;

    @Transactional
    public UserModel users(){
        UserModel user = UserModel.builder()
                .ifsc(1234)
                .balance(5000)
                .branch("Salem")
                .name("subhas")
                .emailId("Subhas@gmail.com")
                .number("6789012345")
                .accountNumber("1234567")
                .address("dubai,dubai kuruku santhu")
                .build();
        userRepo.save(user);
        userRepo.findAll().stream().map(UserModel::toString).forEach(log::info);
        return userRepo.findByaccountNumber("1234567").get(0);
    }
}
