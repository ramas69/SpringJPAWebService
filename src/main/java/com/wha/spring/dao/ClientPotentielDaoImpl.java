package com.wha.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.wha.spring.idao.ClientPotentielDao;
import com.wha.spring.model.ClientPotentiel;

@Repository("clientPtentielDao")
@Transactional
public class ClientPotentielDaoImpl extends AbstractDao implements ClientPotentielDao {

	@Override
	public ClientPotentiel saveClientPotentiel(ClientPotentiel clientPotentiel) {
		em.persist(clientPotentiel);
		return clientPotentiel;
	}

	@Override
	public void updateClientPotentiel(ClientPotentiel clientPotentiel) {
		em.merge(clientPotentiel);

	}

	@Override
	public List<ClientPotentiel> findAllClientsPotentiels() {
		return em.createQuery("From ClientPotentiel").getResultList();
	}

	@Override
	public ClientPotentiel findById(int id) {
		return (ClientPotentiel) em.find(ClientPotentiel.class, id);
	}

	@Override
	public void deleteClientPotentiel(int id) {
		em.remove(findById(id));

	}

}