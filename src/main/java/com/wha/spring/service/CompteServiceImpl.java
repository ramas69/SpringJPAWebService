package com.wha.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.idao.CompteDao;
import com.wha.spring.iservice.CompteService;
import com.wha.spring.model.Compte;

@Service("compteService")
@Transactional
public class CompteServiceImpl implements CompteService {
	@Autowired
	CompteDao compteDAO;

	@Override
	public Compte saveCompte(Compte compte) {
		compteDAO.saveCompte(compte);
		return compte;
	}

	@Override
	public Compte findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCompte(Compte compte) {
		compteDAO.updateCompte(compte);

	}

	@Override
	public List<Compte> findAllComptes() {
		return compteDAO.findAllComptes();
	}

	@Override
	public void deleteCompte(int id) {
		compteDAO.deleteCompte(id);

	}

}
