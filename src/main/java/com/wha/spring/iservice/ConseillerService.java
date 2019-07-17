package com.wha.spring.iservice;

import java.util.List;

import com.wha.spring.model.Compte;
import com.wha.spring.model.Conseiller;


public interface ConseillerService {
	Conseiller saveConseiller(Conseiller conseiller);

	Conseiller findById(int id);

	void updateConseiller(Conseiller conseiller);

	public List<Conseiller> findAllConseillers();

	public void deleteConseiller(int id);
	//**
	public void modificationDecouvert(Compte compte, double montant);
	public void modificationRemuneration(Compte compte,double montant);
}
