package com.wha.spring.idao;

import java.util.List;

import com.wha.spring.model.Compte;
import com.wha.spring.model.Conseiller;

public interface ConseillerDao {
	public Conseiller saveConseiller(Conseiller conseiller);
	public void updateConseiller(Conseiller conseiller);
	public List<Conseiller> findAllConseillers();
	public void deleteConseiller(int id) ;
	public Conseiller findById(int id);
	//***
	public void modificationDecouvert(Compte compte,double montant);
	public void modificationRemuneration(Compte compte,double montant);
	public void validerDemandChequier(Compte compte);
}
