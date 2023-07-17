package com.banking.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.user.entity.CreditCard;
import com.banking.user.service.CreditCardService;

@RestController
@RequestMapping("/creditcard")
public class CreditCardController {
	
	@Autowired
	private CreditCardService creditCardService;
	
	@GetMapping("/{id}")
	public CreditCard getCreditCardById(@PathVariable long id) {
		return creditCardService.getCreditCardById(id);
	}
	
	@PostMapping("/save")
	public void saveCreditCard(@RequestBody CreditCard creditCard) {
		creditCardService.saveCreditCard(creditCard);;
	}
	
	@DeleteMapping("/{id}")
	public void deleteLoan(@PathVariable long id) {
		creditCardService.deleteCreditCard(id);
	}
}
