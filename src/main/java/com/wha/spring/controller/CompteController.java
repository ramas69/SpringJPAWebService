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
import com.wha.spring.iservice.UserService;
import com.wha.spring.model.Compte;
import com.wha.spring.model.User;

@RestController
@RequestMapping("comptes")
public class CompteController {

	@Autowired(required=true)
	CompteService compteService;
	@Autowired
	ClientService clientService;

	@RequestMapping(value = "/create/dummy", method = RequestMethod.GET)
	public Compte dummy() {

		Compte cp=new Compte(0, "00691220", "0069", 1000.0, 200.0, 250.0, 100.0, 250.0, clientService.findById(13), true);
		compteService.saveCompte(cp);
		return cp;

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/get/all", method = RequestMethod.GET)
	public ResponseEntity<List<Compte>> getAll() {
		List<Compte> resultat = compteService.findAllComptes();
		return new ResponseEntity<List<Compte>>(resultat, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/create")
	public Compte createCompte(@RequestBody Compte compte) {
		Compte newCompte = compteService.saveCompte(compte);
		return newCompte;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/update")
	public Compte updateCompte(@RequestBody Compte compte) {
		compteService.updateCompte(compte);
		return compte;

	}
   // virement
	@CrossOrigin(origins = "http://localhost:4200")
	//@PostMapping("/virement")
	@RequestMapping(value = "/virement/{idCompte1}/{idCompte2}/{type}/{montant}", method = RequestMethod.GET)
	public void virementCompte(@PathVariable int idCompte1,
			@PathVariable int idCompte2, @PathVariable String type,
			@PathVariable double montant) {
		// compteService
		
		Compte cp1 = compteService.findById(idCompte1);
		Compte cp2 = compteService.findById(idCompte2);
		 compteService.virementCompte(cp1, cp2, type, montant);
		
	}
	
	// geller compte
	@CrossOrigin(origins = "http://localhost:4200")
	//@PutMapping("/geler/{idClient}")
	@RequestMapping(value = "/geler/{idCompte}", method = RequestMethod.GET)
	public Compte gelerCompte(@PathVariable int idCompte) {
		Compte compte=compteService.findById(idCompte);
		System.out.println(" id de compte trouvé "+compte.getId()); 
		 compteService.gelerCompte(compte);
		return compte;

	}
	
}
