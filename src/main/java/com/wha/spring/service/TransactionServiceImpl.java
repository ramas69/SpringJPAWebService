package com.wha.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.idao.TransactionDao;
import com.wha.spring.iservice.TransactionService;
import com.wha.spring.model.Transaction;

@Service("transactionService")
@Transactional
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionDao transactionDAO;

	@Override
	public Transaction saveTransaction(Transaction transaction) {
		transactionDAO.saveTransaction(transaction);
		return transaction;
	}

	@Override
	public Transaction findById(int id) {
		return transactionDAO.findById(id);
	}

	@Override
	public void updateTransaction(Transaction transaction) {
		transactionDAO.updateTransaction(transaction);

	}

	@Override
	public List<Transaction> findAllTransactions() {
		return transactionDAO.findAllTransactions();
	}

	@Override
	public void deleteTransaction(int identifiant) {
		transactionDAO.deleteTransaction(identifiant);

	}

}
