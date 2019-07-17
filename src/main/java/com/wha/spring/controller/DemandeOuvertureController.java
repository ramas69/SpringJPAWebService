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

import com.wha.spring.iservice.DemandeOuvertureService;
import com.wha.spring.model.DemandeOuverture;

@RestController
@RequestMapping("demandesOuverture")
public class DemandeOuvertureController {
	@Autowired 
	DemandeOuvertureService DemandeOuvertureService;

	@RequestMapping(value = "/create/dummy", method = RequestMethod.GET)
	public DemandeOuverture dummy() {
		DemandeOuverture deo = new DemandeOuverture(0, null, true, null);	
		DemandeOuvertureService.saveDemandeOuverture(deo);
		System.out.println("valid : "+deo.isValide());
		return deo;
		
		
		
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/get/all", method = RequestMethod.GET)
	public ResponseEntity<List<DemandeOuverture>> getAll() {
		List<DemandeOuverture> resultat = DemandeOuvertureService.findAllDemandeOuvertures();
		return new ResponseEntity<List<DemandeOuverture>>(resultat, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/create")
	public DemandeOuverture createDemandeOuverture(@RequestBody DemandeOuverture demandeOuverture) {
		DemandeOuverture newDemandeOuverture = DemandeOuvertureService.saveDemandeOuverture(demandeOuverture);
		return newDemandeOuverture;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/update")
	public DemandeOuverture updateDemandeOuverture(@RequestBody DemandeOuverture demandeOuverture) {
		DemandeOuvertureService.updateDemandeOuverture(demandeOuverture);
		return demandeOuverture;
	}


}
