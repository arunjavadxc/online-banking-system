package com.banking.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.user.entity.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

}
