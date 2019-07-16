package com.wha.spring.idao;

import java.util.List;

import com.wha.spring.model.Client;


public interface ClientDao {
	Client saveClient(Client client);

	void updateClient(Client client);

	public List<Client> findAllClients();

	Client findById(int identifiant);

	void deleteClient(int identifiant);

}
