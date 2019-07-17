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

import com.wha.spring.iservice.RequeteService;
import com.wha.spring.model.Client;
import com.wha.spring.model.Compte;
import com.wha.spring.model.Requete;
import com.wha.spring.model.TypeRequete;
//import com.wha.spring.model.Requete;

@RestController
@RequestMapping("requete")
public class RequeteController {
	@Autowired /*(required=true)*/
	RequeteService requeteService;

	@RequestMapping(value = "/create/dummy", method = RequestMethod.GET)
	public Requete dummy() {

		//Requete ad=new Requete(0, "nom admin3", "prenom admin3", "admin3@yah.com", "lyon", "032145698", "adminpseudo3", "adminpass3");
		//RequeteService.saveRequete(ad);
		Requete rq=new Requete(0, null, null, " message", TypeRequete.CHEQUIER);
		
		return rq;
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/get/all", method = RequestMethod.GET)
	public ResponseEntity<List<Requete>> getAll() {
		List<Requete> resultat = requeteService.findAllRequetes();
		System.out.println("resultat : "+resultat.toString());
		return new ResponseEntity<List<Requete>> (resultat, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/create")
	public Requete createRequete(@RequestBody Requete requete) {
		Requete newRequete = requeteService.saveRequete(requete);
		return newRequete;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/update")
	public Requete updateRequete(@RequestBody Requete requete) {
		requeteService.updateRequete(requete);
		return requete;
	}

}
