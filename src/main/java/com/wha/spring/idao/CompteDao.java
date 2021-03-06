package com.wha.spring.idao;

import java.util.List;

import com.wha.spring.model.Client;
import com.wha.spring.model.Compte;

public interface CompteDao {
	
	Compte saveCompte(Compte compte);

	void updateCompte(Compte compte);
	
	public List<Compte> findAllComptes();

	Compte findById(int id);

	void deleteCompte(int id);
	
	public void virementCompte(Compte cp1, Compte cp2, String type, double montant );

	/**  
	 * 
	 */
	//public List<Compte> compteByIdClient(Client client);
	 public List<Compte> findCompteByClient(int idClient) ;
	 
	 public void gelerCompte(Compte compte);
}
