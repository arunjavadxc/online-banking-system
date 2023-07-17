package com.banking.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.user.entity.Loan;
import com.banking.user.exception.LoanException;
import com.banking.user.repository.LoanRepository;

@Service
public class LoanServiceImpl implements LoanService {

	
	@Autowired
	private LoanRepository loanRepository;
	
	@Override
	public Loan getLoanById(long id) {
		return loanRepository.findById(id).orElseThrow(()-> new LoanException("Loan not found " +id));
	}

	@Override
	public void saveLoan(Loan loan) {
		loanRepository.save(loan);
	}

	@Override
	public void deleteLoan(long id) {
		loanRepository.deleteById(id);
	}
}
