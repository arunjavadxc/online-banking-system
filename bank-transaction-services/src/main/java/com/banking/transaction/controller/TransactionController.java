package com.banking.transaction.controller;

import com.banking.transaction.dto.TransactionRequest;
import com.banking.transaction.dto.TransactionResponse;
import com.banking.transaction.service.TransactionService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.banking.transaction.utils.Constants;

import java.util.List;

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
	@ResponseStatus(HttpStatus.CREATED)
	public String postSuccess(@RequestBody TransactionRequest transactionRequest){
		log.info("started form controller");
		log.info(transactionRequest.toString());
		service.addDataToDB(transactionRequest);
		return "Success";
	}

	@PostMapping("/allTransactions/{accountNumber}")
	public List<TransactionResponse> getAllTransactions(@PathVariable String accountNumber){
		return service.getAllTransactions(accountNumber);
	}
}
