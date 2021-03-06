package com.wha.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.idao.CompteDao;
import com.wha.spring.idao.UserDao;
import com.wha.spring.model.Client;
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

	@Override
	public void virementCompte(Compte cp1, Compte cp2, String type,
			double montant) {
		cp1.setSolde(cp1.getSolde()- montant);
		cp2.setSolde(cp2.getSolde()+ montant);
		em.merge(cp1);
		em.merge(cp2);
		
	}


	@SuppressWarnings("unchecked")
	@Override
    public List<Compte> findCompteByClient(int idClient) {
        return em.createQuery("SELECT c FROM Compte c WHERE c.client.id = :custId")
                .setParameter("custId", idClient)
                .getResultList();
        
    }

	@Override
	public void gelerCompte(Compte compte) {
		// TODO Auto-generated method stub
		compte.setGele(true);
		em.merge(compte);
	}
	
	

}
