package com.wha.spring.iservice;

import java.util.List;

import com.wha.spring.model.Compte;

public interface CompteService {
	Compte saveCompte(Compte compte);

	Compte findById(int id);

	void updateCompte(Compte compte);

	public List<Compte> findAllComptes();

	public void deleteCompte(int id);
	
	public void virementCompte(Compte cp1, Compte cp2, String type,
			double montant);
	/** **/
	//public List<Compte> compteByIdClient(int idClient);
	public List<Compte> findCompteByClient(int idClient) ;
	public void gelerCompte(Compte compte);
}
