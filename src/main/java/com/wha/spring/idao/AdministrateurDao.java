package com.wha.spring.idao;

import java.util.List;

import com.wha.spring.model.Administrateur;


public interface AdministrateurDao {
	public Administrateur saveAdministrateur(Administrateur administrateur);
	public void updateAdministrateur(Administrateur administrateur);
	public List<Administrateur> findAllAdministrateurs();
	public void deleteAdministrateur(int id) ;
	public Administrateur findById(int id);
}
