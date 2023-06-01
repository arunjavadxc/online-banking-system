package com.banking.userManagement.repo;

import com.banking.userManagement.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface userRepo extends JpaRepository<UserModel,String> {

    public List<UserModel> findByaccountNumber(String accountNumber);
}

