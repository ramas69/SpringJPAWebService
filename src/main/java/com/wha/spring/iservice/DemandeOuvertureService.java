package com.wha.spring.iservice;

import java.util.List;

import com.wha.spring.model.DemandeOuverture;

public interface DemandeOuvertureService {
	DemandeOuverture saveDemandeOuverture(DemandeOuverture demandeOuverture);

	DemandeOuverture findById(int id);

	void updateDemandeOuverture(DemandeOuverture demandeOuverture);

	public List<DemandeOuverture> findAllDemandeOuvertures();

	public void deleteDemandeOuverture(int id);

}
