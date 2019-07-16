package com.wha.spring.iservice;

import java.util.List;

import com.wha.spring.model.Client;

public interface ClientService {
	Client saveClient(Client client);

	Client findById(int identifiant);

	void updateClient(Client client);

	public List<Client> findAllClients();

	public void deleteClient(int identifiant);

}
