package com.banking.transaction.controller;

import com.banking.transaction.dto.TransactionReqResponse;
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

	//test for github access

	@PostMapping("/Transaction")
	@ResponseStatus(HttpStatus.CREATED)
	public TransactionReqResponse postSuccess(@RequestBody TransactionRequest transactionRequest){
		log.info("started form controller");
		log.info(transactionRequest.toString());
		return service.addTransacrtion(transactionRequest);
	}

	@GetMapping("/Transactions/{accountNumber}")
	public List<TransactionResponse> getAllTransactions(@PathVariable String accountNumber){
		return service.getAllTransactions(accountNumber);
	}
}
