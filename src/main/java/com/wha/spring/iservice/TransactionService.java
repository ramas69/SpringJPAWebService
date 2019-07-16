package com.wha.spring.iservice;

import java.util.List;

import com.wha.spring.model.Transaction;


public interface TransactionService {
	Transaction saveTransaction(Transaction transaction);

	Transaction findById(int id);

	void updateTransaction(Transaction transaction);

	public List<Transaction> findAllTransactions();

	public void deleteTransaction(int id);


}
