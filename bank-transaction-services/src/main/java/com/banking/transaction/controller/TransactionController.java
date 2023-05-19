package com.banking.transaction.controller;

import com.banking.transaction.dto.transactionRequest;
import com.banking.transaction.service.TransactionService;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.banking.transaction.utils.Constants;

@RequestMapping(path = Constants.API_PREFIX_V1)
@RestController
@Log4j2
public class TransactionController {
	@Autowired
	private TransactionService service;
	@GetMapping("/test")
	public String testMethod() {
		return "Transaction test controller";
	}

	//test for github access
	@PostMapping("/transaction")
	public String postSuccess(){
		log.info("started form controller");
		service.addDataToDB();
		return "Success";
	}

}
