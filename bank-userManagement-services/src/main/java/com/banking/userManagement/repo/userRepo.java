package com.banking.userManagement.repo;

import com.banking.userManagement.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface userRepo extends JpaRepository<UserModel,String> {

    public UserModel findByaccountNumber(String accountNumber);

//    @Modifying
//    @Query("update users u set u.balance = ?1 where u.accountNumber = ?2")
//    void updateBalance( double balance,  String accountNumber);
}

