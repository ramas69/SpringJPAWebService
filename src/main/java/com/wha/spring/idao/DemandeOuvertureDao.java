package com.wha.spring.idao;

import java.util.List;

import com.wha.spring.model.Conseiller;
import com.wha.spring.model.DemandeOuverture;

public interface DemandeOuvertureDao {
	DemandeOuverture saveDemandeOuverture(DemandeOuverture demandeOuverture);

	void updateDemandeOuverture(DemandeOuverture demandeOuverture);

	public List<DemandeOuverture> findAllDemandeOuvertures();

	DemandeOuverture findById(int id);

	void deleteDemandeOuverture(int id);

	void affectationDemandeOuverture(DemandeOuverture demandeOuverture, Conseiller conseiller);

}
