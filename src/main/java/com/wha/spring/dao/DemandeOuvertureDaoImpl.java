package com.wha.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.idao.DemandeOuvertureDao;
import com.wha.spring.model.Conseiller;
import com.wha.spring.model.DemandeOuverture;

@Repository("demandeOuvertureDao")
@Transactional
public class DemandeOuvertureDaoImpl extends AbstractDao implements DemandeOuvertureDao {

	@Override
	public DemandeOuverture saveDemandeOuverture( DemandeOuverture demandeOuverture) {
		em.persist(demandeOuverture);
		return demandeOuverture;
	}

	@Override
	public void updateDemandeOuverture(DemandeOuverture demandeOuverture) {
		em.merge(demandeOuverture);

	}

	@Override
	public List<DemandeOuverture> findAllDemandeOuvertures() {
		return em.createQuery("From DemandeOuverture").getResultList();
	}

	@Override
	public DemandeOuverture findById(int id) {
		return (DemandeOuverture) em.find(DemandeOuverture.class, id);
	}

	@Override
	public void deleteDemandeOuverture(int id) {
		em.remove(findById(id));

	}
	
	 public void affectationDemandeOuverture(DemandeOuverture demandeOuverture, Conseiller conseiller) {
		 demandeOuverture.setConseiller(conseiller);
	        em.merge(demandeOuverture);
	 }

}
