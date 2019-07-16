package com.wha.spring.idao;

import java.util.List;

import com.wha.spring.model.Requete;

public interface RequeteDao {
	Requete saveRequete(Requete requete);

	void updateRequete(Requete requete);
	
	public List<Requete> findAllRequetes();

	Requete findById(int id);

	void deleteRequete(int id);

}
