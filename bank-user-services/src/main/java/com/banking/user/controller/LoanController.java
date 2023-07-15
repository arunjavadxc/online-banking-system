package com.banking.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.user.entity.Loan;
import com.banking.user.service.LoanService;

@RestController
@RequestMapping("/loans")
public class LoanController {

	@Autowired
	private LoanService loanService;
	
	@GetMapping("/{id}")
	public Loan getLoanById(@PathVariable long id) {
		return loanService.getLoanById(id);
	}
	
	@PostMapping("/save")
	public void saveLoan(@RequestBody Loan loan) {
		loanService.saveLoan(loan);
	}
	
	@DeleteMapping("/{id}")
	public void deleteLoan(@PathVariable long id) {
		loanService.deleteLoan(id);
	}
}

