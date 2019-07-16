package com.wha.spring.iservice;

import java.util.List;

import com.wha.spring.model.ClientPotentiel;

public interface ClientPotentielService {
	ClientPotentiel saveClientPotentiel(ClientPotentiel clientPotentiel);

	ClientPotentiel findById(int id);

	void updateClientPotentiel(ClientPotentiel clientPotentiel);

	public List<ClientPotentiel> findAllClientsPotentiels();

	public void deleteClientPotentiel(int id);

}
