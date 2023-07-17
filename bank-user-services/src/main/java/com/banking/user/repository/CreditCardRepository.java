package com.banking.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.user.entity.CreditCard;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long>{

}
