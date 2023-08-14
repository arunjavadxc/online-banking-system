package com.banking.transaction.service;

import com.banking.transaction.Exceptions.InsufficientBalance;
import com.banking.transaction.dto.TransactionReqResponse;
import com.banking.transaction.dto.TransactionRequest;
import com.banking.transaction.dto.TransactionResponse;
import com.banking.transaction.model.TransactionModel;
import com.banking.transaction.repo.TransactionImp;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
public class TransactionServiceImp implements TransactionService {
	@Autowired
	private TransactionImp transaction;
	@Value("${user.balance.url}")
	private String balanceBaseURL;
	@Autowired
	private RestTemplate rest;

	public TransactionReqResponse addTransacrtion(TransactionRequest data) {
		log.info("Entered into Service layer");
		// check users are present and get balance from them and transfer to addDataToDB
//        RestTemplate rest = new RestTemplate();
		Map balance = getBalance(data.getCreditParty(), data.getDebitParty());
		double creditPartyBalance = Double.parseDouble(balance.get(data.getCreditParty()).toString());
		double debitPartyBalance = Double.parseDouble(balance.get(data.getDebitParty()).toString());

		TransactionModel transResponse = addDataToDB(data, creditPartyBalance, debitPartyBalance);
		Map<String, Double> currentBalance = Map.of(transResponse.getCreditParty(),
				transResponse.getCreditPartyBalance(), transResponse.getDebitParty(),
				transResponse.getDebitPartyBalance());
		// update current balance
		if (updateBalance(currentBalance).getBody() == 2) {
			return TransactionReqResponse.builder().transactionAmount(transResponse.getTransactionAmount())
					.balance(transResponse.getDebitPartyBalance()).receiver(transResponse.getCreditParty()).build();

		} else
			return null;
	}

	@SneakyThrows
	private Map getBalance(String creditAccountNumber, String debitAccountNumber) {
		StringBuilder baseURI = new StringBuilder(balanceBaseURL).append("/multiple");
		List<String> accounts = new ArrayList<>();
		accounts.add(creditAccountNumber);
		accounts.add(debitAccountNumber);
		return rest.postForEntity(baseURI.toString(), accounts, Map.class).getBody();

	}

	private ResponseEntity<Integer> updateBalance(Map<String, Double> currentBalance) {
		System.out.println("Balance update url ->" + balanceBaseURL + "/update");
		return rest.postForEntity(balanceBaseURL + "/update", currentBalance, Integer.class);
	}

	@SneakyThrows
	private TransactionModel addDataToDB(TransactionRequest data, double creditPartyBalance, double debitPartyBalance) {
		if (debitPartyBalance < data.getTransactionAmount())
			throw new InsufficientBalance(data.getDebitParty() + " You don't have sufficient balance");
		return transaction.addToDB(data, creditPartyBalance, debitPartyBalance);
	}

	public List<TransactionResponse> getAllTransactions(String accountNumber) {
		List<TransactionResponse> credit = transaction.getCreditedTransactions(accountNumber);
		List<TransactionResponse> debit = transaction.getDebitedTransactions(accountNumber);
		List<TransactionResponse> allTransactions = Stream.concat(credit.stream(), debit.stream())
				.collect(Collectors.toList());
		return allTransactions.stream().sorted(Comparator.comparing(TransactionResponse::getTransactionDate))
				.collect(Collectors.toList());
	}
}
