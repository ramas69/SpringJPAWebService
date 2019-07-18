package com.wha.spring.idao;

import java.util.List;

import com.wha.spring.model.Client;
import com.wha.spring.model.Compte;
import com.wha.spring.model.Conseiller;
import com.wha.spring.model.DemandeOuverture;
import com.wha.spring.model.Requete;
import com.wha.spring.model.TypeRequete;


public interface ClientDao {
	Client saveClient(Client client);

	void updateClient(Client client);

	public List<Client> findAllClients();

	Client findById(int identifiant);

	void deleteClient(int identifiant);
	
	void reaffectationClient(Client client, Conseiller conseiller);
	
	
	
	
	

	

}
