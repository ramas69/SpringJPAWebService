package com.wha.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.wha.spring.idao.TransactionDao;
import com.wha.spring.model.Transaction;

@Repository("transactionDao")
@Transactional
public class TransactionDaoImpl extends AbstractDao implements TransactionDao {

	@Override
	public Transaction saveTransaction(Transaction transaction) {
		em.persist(transaction);
		return transaction;
	}

	@Override
	public void updateTransaction(Transaction transaction) {
		em.merge(transaction);
		
	}

	@Override
	public List<Transaction> findAllTransactions() {
		return em.createQuery("From Transaction").getResultList();
	}

	@Override
	public Transaction findById(int id) {
		return (Transaction) em.find(Transaction.class, id);
	}

	@Override
	public void deleteTransaction(int id) {
		em.remove(findById(id));
		
	}


}
