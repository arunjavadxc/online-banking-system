package com.banking.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.banking.transaction.dto.TransactionRequest;
import com.banking.transaction.service.TransactionService;
import com.banking.transaction.utils.Constants;
import com.banking.transaction.utils.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@RequestMapping(path = Constants.API_PREFIX_V1)
@RestController
@Slf4j
public class TransactionController {
	@Autowired
	private TransactionService service;

	// To add user transactions

	@PostMapping("/transactions")
	public ResponseEntity<?> postSuccess(@RequestBody TransactionRequest transactionRequest)
			throws JsonProcessingException {
		log.info("started form controller");
		log.info(transactionRequest.toString());

		try {
			return new ResponseEntity<>(service.addTransacrtion(transactionRequest), HttpStatus.CREATED);
		} catch (HttpClientErrorException hce) {
			System.out.println("Server response ::>"
					+ hce.getLocalizedMessage().substring(hce.getLocalizedMessage().indexOf("{")));

			Response response = new ObjectMapper().readValue(
					hce.getLocalizedMessage().substring(hce.getLocalizedMessage().indexOf("{")), Response.class);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}

	}
	// Get all transactions of a user

//	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/transactions/{accountNumber}")
	public ResponseEntity<?> getAllTransactions(@PathVariable String accountNumber) {
		return new ResponseEntity<>(service.getAllTransactions(accountNumber), HttpStatus.OK);
	}
}
