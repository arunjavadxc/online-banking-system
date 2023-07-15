package com.banking.user.service;

import com.banking.user.entity.CreditCard;

public interface CreditCardService {
	
	CreditCard getCreditCardById(long id);
	
	void saveCreditCard(CreditCard creditCard);
	
	void deleteCreditCard(long id);
}
