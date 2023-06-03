package com.banking.userManagement.repo;

import com.banking.userManagement.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepo extends JpaRepository<UserModel,String> {

    public UserModel findByaccountNumber(String accountNumber);
}

