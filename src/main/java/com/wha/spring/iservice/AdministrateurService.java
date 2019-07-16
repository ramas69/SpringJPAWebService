package com.wha.spring.iservice;

import java.util.List;

import com.wha.spring.model.Administrateur;


public interface AdministrateurService {
	Administrateur saveAdministrateur(Administrateur administrateur);

	Administrateur findById(int id);

	void updateAdministrateur(Administrateur administrateur);

	public List<Administrateur> findAllAdministrateurs();

	public void deleteAdministrateur(int id);
}
