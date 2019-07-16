package com.wha.spring.idao;

import java.util.List;

import com.wha.spring.model.Transaction;

public interface TransactionDao {
	Transaction saveTransaction(Transaction transaction);

	void updateTransaction(Transaction transaction);
	
	public List<Transaction> findAllTransactions();

	Transaction findById(int id);

	void deleteTransaction(int id);

}
