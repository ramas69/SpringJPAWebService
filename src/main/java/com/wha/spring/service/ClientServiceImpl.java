package com.wha.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.idao.ClientDao;
import com.wha.spring.idao.DemandeOuvertureDao;
import com.wha.spring.iservice.ClientService;
import com.wha.spring.model.Client;
import com.wha.spring.model.Conseiller;
import com.wha.spring.model.DemandeOuverture;

@Service("clientService")
@Transactional
public class ClientServiceImpl implements ClientService {
	@Autowired
	ClientDao clientDAO;
	
	
	@Override
	public Client saveClient(Client client) {
		clientDAO.saveClient(client);
		return client;
	}

	@Override
	public Client findById(int identifiant) {
		return clientDAO.findById(identifiant);
	}

	@Override
	public void updateClient(Client client) {
		clientDAO.updateClient(client);

	}

	@Override
	public List<Client> findAllClients() {
		return clientDAO.findAllClients();
	}

	@Override
	public void deleteClient(int identifiant) {
		clientDAO.deleteClient(identifiant);

	}
<<<<<<< HEAD
	
	@Override
    public void reaffectationClient(Client client, Conseiller conseiller) {
        clientDAO.reaffectationClient(client, conseiller);        
        
    }
	
	
=======

	@Override
	public List<Client> findClientByCompte(int idCompte) {
		// TODO Auto-generated method stub
		return clientDAO.findClientByCompte(idCompte);
		//return null;
	}

>>>>>>> springJeudiMatin
}
