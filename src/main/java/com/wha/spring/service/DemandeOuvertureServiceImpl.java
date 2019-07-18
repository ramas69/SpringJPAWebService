package com.wha.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.idao.DemandeOuvertureDao;
import com.wha.spring.iservice.DemandeOuvertureService;
import com.wha.spring.model.Conseiller;
import com.wha.spring.model.DemandeOuverture;


@Service("DemandeOuverture")
@Transactional
public class DemandeOuvertureServiceImpl implements DemandeOuvertureService {

	@Autowired
	DemandeOuvertureDao DemandeOuvertureDAO;
	
	@Autowired
	DemandeOuvertureDao demandeOuvertureDAO;


	@Override
	public DemandeOuverture saveDemandeOuverture(DemandeOuverture demandeOuverture) {
		DemandeOuvertureDAO.saveDemandeOuverture(demandeOuverture);
		return demandeOuverture;
	}

	@Override
	public DemandeOuverture findById(int id) {
		return DemandeOuvertureDAO.findById(id);
	}

	@Override
	public void updateDemandeOuverture(DemandeOuverture demandeOuverture) {
		DemandeOuvertureDAO.updateDemandeOuverture(demandeOuverture);

	}

	@Override
	public List<DemandeOuverture> findAllDemandeOuvertures() {
		return DemandeOuvertureDAO.findAllDemandeOuvertures();
	}

	@Override
	public void deleteDemandeOuverture(int id) {
		DemandeOuvertureDAO.deleteDemandeOuverture(id);
	}
	
	@Override
    public void affectationDemandeOuverture(DemandeOuverture demandeOuverture, Conseiller conseiller) {
        demandeOuvertureDAO.affectationDemandeOuverture(demandeOuverture, conseiller);        
        
    }

}

