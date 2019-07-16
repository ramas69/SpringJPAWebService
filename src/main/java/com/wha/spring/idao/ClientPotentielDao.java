package com.wha.spring.idao;

import java.util.List;

import com.wha.spring.model.ClientPotentiel;

public interface ClientPotentielDao {
	ClientPotentiel saveClientPotentiel(ClientPotentiel clientPotentiel);
	
	void updateClientPotentiel(ClientPotentiel clientPotentiel);
	
	public List<ClientPotentiel> findAllClientsPotentiels();
	
	ClientPotentiel findById(int id);
	
	void deleteClientPotentiel(int id);

}
