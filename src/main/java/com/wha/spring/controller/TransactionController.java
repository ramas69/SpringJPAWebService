package com.wha.spring.controller;


import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.wha.spring.iservice.TransactionService;
import com.wha.spring.model.Transaction;

@RestController
@RequestMapping("transactions")
public class TransactionController {
	@Autowired 
	TransactionService transactionService;

	@RequestMapping(value = "/create/dummy", method = RequestMethod.GET)
	public Transaction dummy() {
		Transaction tr1 = new Transaction(0, 12.0, null, "debit", Calendar.getInstance());
		transactionService.saveTransaction(tr1);
		return tr1;
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/get/all", method = RequestMethod.GET)
	public ResponseEntity<List<Transaction>> getAll() {
		List<Transaction> resultat = transactionService.findAllTransactions();
		return new ResponseEntity<List<Transaction>>(resultat, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/create")
	public Transaction createTransaction(@RequestBody Transaction Transaction) {
		Transaction newTransaction = transactionService.saveTransaction(Transaction);
		return newTransaction;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/update")
	public Transaction updateTransaction(@RequestBody Transaction Transaction) {
		transactionService.updateTransaction(Transaction);
		return Transaction;
	}

}
