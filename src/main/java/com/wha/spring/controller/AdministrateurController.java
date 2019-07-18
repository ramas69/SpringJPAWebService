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

import com.wha.spring.iservice.AdministrateurService;
import com.wha.spring.iservice.ClientService;
import com.wha.spring.iservice.ConseillerService;
import com.wha.spring.iservice.DemandeOuvertureService;
import com.wha.spring.model.Administrateur;
import com.wha.spring.model.Client;
import com.wha.spring.model.ClientPotentiel;
import com.wha.spring.model.Compte;
import com.wha.spring.model.Conseiller;
import com.wha.spring.model.DemandeOuverture;


@RestController
@RequestMapping("admin")
public class AdministrateurController {
	
	@Autowired /*(required=true)*/
	AdministrateurService administrateurService;
	
	@Autowired
	ClientService clientService;
	
	@Autowired
	ConseillerService conseillerService;
	
	@Autowired
	DemandeOuvertureService demandeOuvertureService;
	

	@RequestMapping(value = "/create/dummy", method = RequestMethod.GET)
	public Administrateur dummy() {

		Administrateur ad=new Administrateur(0, "nom admin3", "prenom admin3", "admin3@yah.com", "lyon", "032145698", "adminpseudo3", "adminpass3");
		administrateurService.saveAdministrateur(ad);
		
		return ad;
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/get/all", method = RequestMethod.GET)
	public ResponseEntity<List<Administrateur>> getAll() {
		List<Administrateur> resultat = administrateurService.findAllAdministrateurs();
		System.out.println("resultat : "+resultat.toString());
		return new ResponseEntity<List<Administrateur>> (resultat, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/create")
	public Administrateur createAdministrateur(@RequestBody Administrateur administrateur) {
		Administrateur newAdministrateur = administrateurService.saveAdministrateur(administrateur);
		return newAdministrateur;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/update")
	public Administrateur updateaAministrateur(@RequestBody Administrateur administrateur) {
		administrateurService.updateAdministrateur(administrateur);
		return administrateur;
	}

	@PutMapping("/reaffectation/{idCl}/{idCs}")
    public void reaffectationClient(@PathVariable int idCl, @PathVariable int idCs) {
        Conseiller newConseiller = conseillerService.findById(idCs);
        Client client = clientService.findById(idCl);
        clientService.reaffectationClient(client, newConseiller);
    }
	
	@PutMapping("/affectation/{idDou}/{idCn}")
    public void affectationDemandeOuverture(@PathVariable int idDou, @PathVariable int idCn) {
        Conseiller newConseiller = conseillerService.findById(idCn);
        DemandeOuverture demandeOuverture = demandeOuvertureService.findById(idDou);
        demandeOuvertureService.affectationDemandeOuverture(demandeOuverture, newConseiller);
    }
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/addConseiller", method = RequestMethod.POST)	
	public Conseiller ajouterConseiller(@RequestBody Conseiller conseiller) {     
		return conseillerService.saveConseiller(conseiller);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/suppConseiller/{id}", method = RequestMethod.DELETE)	
	public ResponseEntity<String> deleteConseiller(@PathVariable  int id) { 
		try {
			conseillerService.deleteConseiller(id);
			return new ResponseEntity<>(
				      "Suppression effectué avec succès" , 
				      HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
			          "Impossible de supprimer de ce conseiller", 
			          HttpStatus.BAD_REQUEST);
		}
		
	}
	
}
