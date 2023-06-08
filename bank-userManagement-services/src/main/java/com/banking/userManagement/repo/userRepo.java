package com.banking.userManagement.repo;

import com.banking.userManagement.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface userRepo extends JpaRepository<UserModel,String> {

    public UserModel findByaccountNumber(String accountNumber);

    @Modifying
    @Transactional
    @Query("UPDATE UserModel u SET u.balance = ?1 WHERE u.accountNumber = ?2")
    Integer updateBalance( double balance,  String accountNumber);
}

