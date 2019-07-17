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

import com.wha.spring.iservice.CompteService;
import com.wha.spring.iservice.UserService;
import com.wha.spring.model.Compte;
import com.wha.spring.model.User;


@RestController
@RequestMapping("comptes")
public class CompteController {
	


	@Autowired 
	CompteService compteService;

	@RequestMapping(value = "/create/dummy", method = RequestMethod.GET)
	public Compte dummy() {
		//Compte cp1 = new Compte(0," rib", "25415", 2500.00, 1500.21, 521.69, 100.50, 1200.54, 1);
		//Compte cp1 = new Compte(id, rib, nCompte, solde, decouvert, mntantAgios, seuilRemuneration, montantRemuneration, client)
		
		Compte cp1 =new Compte();
		cp1.setId(0);
		cp1.setRib("12345");
		cp1.setNCompte("00124500");
		cp1.setSolde(2500.00);
		cp1.setDecouvert(1500.21);
		cp1.setMntantAgios(251.69);
		cp1.setSeuilRemuneration(100.50);
		cp1.setMontantRemuneration(1200.54);
		//compteService.saveCompte(cp1);
		compteService.saveCompte(cp1);
		return cp1;
		
		
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

}
