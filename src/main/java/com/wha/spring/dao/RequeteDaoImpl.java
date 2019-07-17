package com.wha.spring.dao;

import java.util.List;



import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.idao.RequeteDao;
import com.wha.spring.model.Requete;

@Repository("requeteDao")
@Transactional
public class RequeteDaoImpl extends AbstractDao implements RequeteDao{

	@Override
	public Requete saveRequete(Requete requete) {
		em.persist(requete);
		return requete;
	}

	@Override
	public void updateRequete(Requete requete) {
		// TODO Auto-generated method stub
		em.merge(requete);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Requete> findAllRequetes() {
		// TODO Auto-generated method stub
		return em.createQuery("From Requete").getResultList();
	}

	@Override
	public Requete findById(int id) {
		// TODO Auto-generated method stub
		return (Requete) em.find(Requete.class, id);
	}

	@Override
	public void deleteRequete(int id) {
		// TODO Auto-generated method stub
		em.remove(findById(id));
	}

}
