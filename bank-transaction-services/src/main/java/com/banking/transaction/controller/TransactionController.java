package com.banking.transaction.controller;

import com.banking.transaction.dto.TransactionReqResponse;
import com.banking.transaction.dto.TransactionRequest;
import com.banking.transaction.dto.TransactionResponse;
import com.banking.transaction.service.TransactionService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.banking.transaction.utils.Constants;

import java.util.List;

@RequestMapping(path = Constants.API_PREFIX_V1)
@RestController
@Slf4j
public class TransactionController {
	@Autowired
	private TransactionService service;

	//To add user transactions

	@PostMapping("/transaction")
	@ResponseStatus(HttpStatus.CREATED)
	public TransactionReqResponse postSuccess(@RequestBody TransactionRequest transactionRequest){
		log.info("started form controller");
		log.info(transactionRequest.toString());
		return service.addTransacrtion(transactionRequest);
	}
	// Get all transactions of a user
	@GetMapping("/transactions/{accountNumber}")
	public List<TransactionResponse> getAllTransactions(@PathVariable String accountNumber){
		return service.getAllTransactions(accountNumber);
	}
}
