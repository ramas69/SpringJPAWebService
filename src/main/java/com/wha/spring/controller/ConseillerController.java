package com.wha.spring.controller;

import java.util.List;

import javax.websocket.server.PathParam;

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

import com.wha.spring.iservice.CompteService;
import com.wha.spring.iservice.ConseillerService;
import com.wha.spring.iservice.RequeteService;
import com.wha.spring.model.Compte;
import com.wha.spring.model.Conseiller; 

@RestController
@RequestMapping("conseiller")
public class ConseillerController {
	@Autowired(required = true)
	ConseillerService conseillerService;

	@Autowired
	CompteService compteService;
	/*@Autowired
	RequeteService requeteService;
*/
	@RequestMapping(value = "/create/dummy", method = RequestMethod.GET)
	public Conseiller dummy() {


  		Conseiller cs=new Conseiller(0, "omar", "kabil", "omar@h.fr", "bron", "0231456598", "omar01", "omar02");
  		conseillerService.saveConseiller(cs);
  		return cs;
		

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/get/all", method = RequestMethod.GET)
	public ResponseEntity<List<Conseiller>> getAll() {
		List<Conseiller> resultat = conseillerService.findAllConseillers();
		return new ResponseEntity<List<Conseiller>>(resultat, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/create")
	public Conseiller createConseiller(@RequestBody Conseiller conseiller) {
		Conseiller newConseiller = conseillerService.saveConseiller(conseiller);
		return newConseiller;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/update")
	public Conseiller updateConseiller(@RequestBody Conseiller conseiller) {

		conseillerService.updateConseiller(conseiller);
		return conseiller;
	}
	
		
//	@CrossOrigin(origins = "http://localhost:4200")
//	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
//	public void deleteConseiller(@PathVariable int id) {
//		 conseillerService.deleteConseiller(id);
//		
//	}

	/**
	 * 
	 */

	@RequestMapping(value = "/modifdecouv/{compteId}/{montant1}", method = RequestMethod.GET)
	public Compte modifDecouv(@PathVariable int compteId,@PathVariable double montant1) {
		Compte compte = compteService.findById(compteId);
		System.out.println("compte trouvé : ");
		conseillerService.modificationDecouvert(compte, montant1);
		return compte;
	}
	@RequestMapping(value = "/modifrenum/{compteId}/{montant1}", method = RequestMethod.GET)
	public Compte modifRenum(@PathVariable int compteId,@PathVariable double montant1) {
		Compte compte = compteService.findById(compteId);
		System.out.println("compte trouvé : ");
		conseillerService.modificationRemuneration(compte, montant1);
		return compte;
	}
	
	
}
