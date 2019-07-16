package com.wha.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.idao.ClientPotentielDao;
import com.wha.spring.iservice.ClientPotentielService;
import com.wha.spring.model.ClientPotentiel;

@Service("clientPotentielService")
@Transactional
public class ClientPotentielServiceImpl implements ClientPotentielService {
	@Autowired
	ClientPotentielDao ClientPotentielDAO;

	@Override
	public ClientPotentiel saveClientPotentiel(ClientPotentiel clientPotentiel) {
		ClientPotentielDAO.saveClientPotentiel(clientPotentiel);
		return clientPotentiel;
	}

	@Override
	public ClientPotentiel findById(int id) {
		return ClientPotentielDAO.findById(id);
	}

	@Override
	public void updateClientPotentiel(ClientPotentiel clientPotentiel) {
		ClientPotentielDAO.updateClientPotentiel(clientPotentiel);

	}

	@Override
	public List<ClientPotentiel> findAllClientsPotentiels() {
		return ClientPotentielDAO.findAllClientsPotentiels();
	}

	@Override
	public void deleteClientPotentiel(int id) {
		ClientPotentielDAO.deleteClientPotentiel(id);
	}

}
