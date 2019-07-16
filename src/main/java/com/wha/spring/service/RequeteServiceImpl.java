package com.wha.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.idao.RequeteDao;
import com.wha.spring.iservice.RequeteService;
import com.wha.spring.model.Requete;
@Service("requeteService")
@Transactional
public class RequeteServiceImpl implements RequeteService{
	@Autowired
	RequeteDao requeteDao;
	
	@Override
	public Requete saveRequete(Requete requete) {
		// TODO Auto-generated method stub
		requeteDao.saveRequete(requete);
		return requete;
	}

	@Override
	public Requete findById(int id) {
		// TODO Auto-generated method stub
		return requeteDao.findById(id);
		}

	@Override
	public void updateRequete(Requete requete) {
		// TODO Auto-generated method stub
		requeteDao.updateRequete(requete);
	}

	@Override
	public List<Requete> findAllRequetes() {
		// TODO Auto-generated method stub
		return requeteDao.findAllRequetes();
	}

	@Override
	public void deleteRequete(int id) {
		// TODO Auto-generated method stub
		requeteDao.deleteRequete(id);
	}

}
