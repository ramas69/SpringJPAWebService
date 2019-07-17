package com.wha.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.idao.CompteDao;
import com.wha.spring.idao.UserDao;
import com.wha.spring.model.Compte;
import com.wha.spring.model.User;

import org.springframework.stereotype.Repository;

@Repository("compteDao")
@Transactional
public class CompteDaoImpl extends AbstractDao implements CompteDao {

	@Override
	public Compte saveCompte(Compte compte) {
		em.persist(compte);
		return compte;
	}

	@Override
	public void updateCompte(Compte compte) {
		em.merge(compte);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Compte> findAllComptes() {
		return em.createQuery("From Compte").getResultList();
	}

	@Override
	public Compte findById(int id) {
		return (Compte) em.find(Compte.class, id);
	}

	@Override
	public void deleteCompte(int id) {
		em.remove(findById(id));
		
	}

}
