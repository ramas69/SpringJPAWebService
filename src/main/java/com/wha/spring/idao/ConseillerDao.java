package com.wha.spring.idao;

import java.util.List;

import com.wha.spring.model.Conseiller;

public interface ConseillerDao {
	public Conseiller saveConseiller(Conseiller conseiller);
	public void updateConseiller(Conseiller conseiller);
	public List<Conseiller> findAllConseillers();
	public void deleteConseiller(int id) ;
	public Conseiller findById(int id);
}
