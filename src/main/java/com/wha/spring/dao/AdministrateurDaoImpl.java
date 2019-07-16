package com.wha.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.idao.AdministrateurDao;
import com.wha.spring.model.Administrateur;


@Repository("administrateurDao")
@Transactional
public class AdministrateurDaoImpl extends AbstractDao implements AdministrateurDao{

	@Override
	public Administrateur saveAdministrateur(Administrateur administrateur) {
		// TODO Auto-generated method stub
		em.persist(administrateur);
		//Appel de la méthod debug de la class Logger
		return administrateur;
	}

	@Override
	public void updateAdministrateur(Administrateur administrateur) {
		// TODO Auto-generated method stub
		em.merge(administrateur);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Administrateur> findAllAdministrateurs() {
		// TODO Auto-generated method stub
		return em.createQuery("From Administrateur where user_type=Administrateur").getResultList();
	}

	@Override
	public void deleteAdministrateur(int id) {
		// TODO Auto-generated method stub
		em.remove(findById(id));
	}

	@Override
	public Administrateur findById(int id) {
		// TODO Auto-generated method stub
		return (Administrateur) em.find(Administrateur.class, id);
	}
	

}
