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



import com.wha.spring.iservice.ClientService;
import com.wha.spring.model.Client;


@RestController
@RequestMapping("clients")
public class ClientController {
	@Autowired 
	ClientService clientService;

	@RequestMapping(value = "/create/dummy", method = RequestMethod.GET)
	public void dummy() {
		Client cl1 = new Client(0, "nom"," prenom", "email", "adress", "telephone", "pseudo", "mdp", 001, 25.5,"piecesJustif" );
		clientService.saveClient(cl1);
		Client cl2 = new Client(0, "nom1"," prenom1", "email1", "adress1", "telephone1", "pseudo1", "mdp1", 002, 30.5,"piecesJustif1" );
		clientService.saveClient(cl2);
		
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/get/all", method = RequestMethod.GET)
	public ResponseEntity<List<Client>> getAll() {
		List<Client> resultat = clientService.findAllClients();
		return new ResponseEntity<List<Client>>(resultat, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/create")
	public Client createClient(@RequestBody Client client) {
		Client newClient = clientService.saveClient(client);
		return newClient;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/update")
	public Client updateClient(@RequestBody Client client) {
		clientService.updateClient(client);
		return client;
	}

}
