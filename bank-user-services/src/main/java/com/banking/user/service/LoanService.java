package com.banking.user.service;

import com.banking.user.entity.Loan;

public interface LoanService {
	
	Loan getLoanById(long id);
	
	void saveLoan(Loan loan);
	
	void deleteLoan(long id);

}
