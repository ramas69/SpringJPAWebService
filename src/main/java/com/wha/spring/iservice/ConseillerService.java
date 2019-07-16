package com.wha.spring.iservice;

import java.util.List;

import com.wha.spring.model.Conseiller;


public interface ConseillerService {
	Conseiller saveConseiller(Conseiller conseiller);

	Conseiller findById(int id);

	void updateConseiller(Conseiller conseiller);

	public List<Conseiller> findAllConseillers();

	public void deleteConseiller(int id);
}
