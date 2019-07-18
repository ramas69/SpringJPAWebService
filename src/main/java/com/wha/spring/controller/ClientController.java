package com.wha.spring.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wha.spring.iservice.ClientService;
import com.wha.spring.iservice.CompteService;
import com.wha.spring.iservice.RequeteService;
import com.wha.spring.iservice.TransactionService;
import com.wha.spring.model.Client;
import com.wha.spring.model.Compte;
import com.wha.spring.model.Requete;
import com.wha.spring.model.Transaction;


@RestController
@RequestMapping("clients")
public class ClientController {
	@Autowired 
	ClientService clientService;
	
	@Autowired
	RequeteService requeteService;
	
	@Autowired
	CompteService compteService;
	
	@Autowired
	TransactionService transactionService;

	@RequestMapping(value = "/create/dummy", method = RequestMethod.GET)
	public Client dummy() {
		Client cl1 = new Client(0, "nom"," prenom", "email", "adress", "telephone", "pseudo", "mdp", 001, 25.5,"piecesJustif" );
		clientService.saveClient(cl1);
        return cl1;
		
		
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

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/demandes", method = RequestMethod.POST)
	public Requete demandeRequete(@RequestBody Requete requete) {     
		return requeteService.saveRequete(requete);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/compte/{id}", method = RequestMethod.GET)	
	public Compte afficherCompte(@PathVariable int id) {     
		return compteService.findById(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/comptes", method = RequestMethod.GET)
	public List<Compte>  afficherListCompte() {     
		return compteService.findAllComptes();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/transaction/{id}", method = RequestMethod.GET)	
	public Transaction afficherTransaction(@PathVariable int id) {     
		return transactionService.findById(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/transactions", method = RequestMethod.GET)
	public List<Transaction> listTransaction() {     		
		return transactionService.findAllTransactions();
	}
	
	
	

}
