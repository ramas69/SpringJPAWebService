package com.wha.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wha.spring.iservice.ClientPotentielService;
import com.wha.spring.model.ClientPotentiel;

@RestController
@RequestMapping("clientsPotentiels")
public class ClientPotentielController {
	
	@Autowired 
	ClientPotentielService clientPotentielService;

	@RequestMapping(value = "/create/dummy", method = RequestMethod.GET)
	public void dummy() {
		ClientPotentiel cl2 = new ClientPotentiel(0, "nom"," prenom", "email", "adress", "telephone", 28.5,"piecesJustif2" );
		clientPotentielService.saveClientPotentiel(cl2);
		
		
		
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/get/all", method = RequestMethod.GET)
	public ResponseEntity<List<ClientPotentiel>> getAll() {
		List<ClientPotentiel> resultat = clientPotentielService.findAllClientsPotentiels();
		return new ResponseEntity<List<ClientPotentiel>>(resultat, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/create")
	public ClientPotentiel createClientPotentiel(@RequestBody ClientPotentiel ClientPotentiel) {
		ClientPotentiel newClientPotentiel = clientPotentielService.saveClientPotentiel(ClientPotentiel);
		return newClientPotentiel;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/update")
	public ClientPotentiel updateClientPotentiel(@RequestBody ClientPotentiel ClientPotentiel) {
		clientPotentielService.updateClientPotentiel(ClientPotentiel);
		return ClientPotentiel;
	}

}
