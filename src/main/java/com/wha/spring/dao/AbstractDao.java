package com.wha.spring.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;





public abstract class AbstractDao {
	@PersistenceContext
	protected EntityManager em;


	protected void persist(Object entity) {
		em.persist(entity);
	}

	protected void delete(Object entity) {
		em.remove(entity);
	}
}
