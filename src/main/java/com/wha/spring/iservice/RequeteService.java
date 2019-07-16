package com.wha.spring.iservice;

import java.util.List;

import com.wha.spring.model.Requete;

public interface RequeteService {
	Requete saveRequete(Requete requete);

	Requete findById(int id);

	void updateRequete(Requete requete);

	public List<Requete> findAllRequetes();

	public void deleteRequete(int id);
}
