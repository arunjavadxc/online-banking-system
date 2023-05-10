package com.banking.transaction.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.transaction.utils.Constants;

@RequestMapping(path = Constants.API_PREFIX_V1)
@RestController
public class TransactionController {

	@GetMapping("/test")
	public String testMethod() {
		return "Transaction test controller";
	}

}
