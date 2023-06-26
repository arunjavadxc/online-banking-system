package com.banking.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.user.entity.CreditCard;
import com.banking.user.exception.CreditCardException;
import com.banking.user.repository.CreditCardRepository;

@Service
public class CreditCardServiceImpl implements CreditCardService {

	@Autowired
	private CreditCardRepository creditCardRepository;
	
	@Override
	public CreditCard getCreditCardById(long id) {
		return creditCardRepository.findById(id).orElseThrow(()-> new CreditCardException("Credit Card not found " +id));
	}

	@Override
	public void saveCreditCard(CreditCard creditCard) {
		creditCardRepository.save(creditCard);
	}

	@Override
	public void deleteCreditCard(long id) {
		creditCardRepository.deleteById(id);
	}

}
