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

import com.wha.spring.iservice.ConseillerService;
import com.wha.spring.model.Conseiller;

@RestController
@RequestMapping("conseiller")
public class ConseillerController {
	@Autowired (required=true)
	ConseillerService conseillerService;

	@RequestMapping(value = "/create/dummy", method = RequestMethod.GET)
	public void dummy() {

  		Conseiller cs=new Conseiller(0, "omar", "kabil", "omar@h.fr", "bron", "0231456598", "omar01", "omar02");
  		conseillerService.saveConseiller(cs);
		
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
}
