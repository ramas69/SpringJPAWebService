package com.wha.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.idao.AdministrateurDao;
import com.wha.spring.iservice.AdministrateurService;
import com.wha.spring.model.Administrateur;


@Service("administrateurService")
@Transactional
public class AdministrateurServiceImpl implements AdministrateurService{
	@Autowired
	AdministrateurDao administrateurDao;
	
	public Administrateur saveAdministrateur(Administrateur administrateur) {
		administrateurDao.saveAdministrateur(administrateur);
		return administrateur;

	}

	public void updateAdministrateur(Administrateur administrateur) {
		administrateurDao.updateAdministrateur(administrateur);
	}

	public List<Administrateur> findAllAdministrateurs() {
		return administrateurDao.findAllAdministrateurs();
	}

	public void deleteAdministrateur(int id) {
		
		administrateurDao.deleteAdministrateur(id);
	}

	public Administrateur findById(int id) {
		return administrateurDao.findById(id);
	}
}
