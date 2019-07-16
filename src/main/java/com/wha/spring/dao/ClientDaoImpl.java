package com.wha.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.idao.ClientDao;
import com.wha.spring.model.Client;

@Repository("clientDao")
@Transactional
public class ClientDaoImpl extends AbstractDao implements ClientDao {

	@Override
	public Client saveClient(Client client) {
		em.persist(client);
		return client;
	}

	@Override
	public void updateClient(Client client) {
		em.merge(client);

	}

	@Override
	public List<Client> findAllClients() {
		return em.createQuery("From Client").getResultList();
	}

	@Override
	public Client findById(int identifiant) {
		return (Client) em.find(Client.class, identifiant);
	}

	@Override
	public void deleteClient(int identifiant) {
		em.remove(findById(identifiant));

	}

}
