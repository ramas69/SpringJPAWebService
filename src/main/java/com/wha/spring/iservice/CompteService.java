package com.wha.spring.iservice;

import java.util.List;

import com.wha.spring.model.Compte;

public interface CompteService {
	Compte saveCompte(Compte compte);

	Compte findById(int id);

	void updateCompte(Compte compte);

	public List<Compte> findAllComptes();

	public void deleteCompte(int id);

}