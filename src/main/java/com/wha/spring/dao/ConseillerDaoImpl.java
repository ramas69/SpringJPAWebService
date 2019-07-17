package com.wha.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.idao.ConseillerDao;
import com.wha.spring.model.Compte;
import com.wha.spring.model.Conseiller;
import com.wha.spring.model.Requete;

@Repository("coseilleirDao")
@Transactional
public class ConseillerDaoImpl extends AbstractDao implements ConseillerDao {

	@Override
	public Conseiller saveConseiller(Conseiller conseiller) {
		// TODO Auto-generated method stub
		em.persist(conseiller);
		//Appel de la méthod debug de la class Logger
		return conseiller;
	}

	@Override
	public void updateConseiller(Conseiller conseiller) {
		// TODO Auto-generated method stub
		em.merge(conseiller);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Conseiller> findAllConseillers() {
		// TODO Auto-generated method stub
		return em.createQuery("From Conseiller ").getResultList();
	}

	@Override
	public void deleteConseiller(int id) {
		// TODO Auto-generated method stub
		em.remove(findById(id));
	}

	@Override
	public Conseiller findById(int id) {
		// TODO Auto-generated method stub
		return (Conseiller) em.find(Conseiller.class, id);
	}

	@Override
	public void modificationDecouvert(Compte compte, double montant) {
		// TODO Auto-generated method stub
		compte.setDecouvert(montant);
		em.merge(compte);
	}

	@Override
	public void modificationRemuneration(Compte compte, double montant) {
		// TODO Auto-generated method stub
		compte.setMontantRemuneration(montant);
		em.merge(compte);
	}

	@Override
	public void validerDemandChequier(Compte compte) {
		// TODO Auto-generated method stub
		//compte.getId();
		
	}
	

}
