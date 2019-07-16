package com.wha.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("Conseiller")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Conseiller")
public class Conseiller extends User{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	List<Client> listClient = new ArrayList<Client>();
	List<Requete> listeDemandeClients= new ArrayList<Requete>();
	List<DemandeOuverture> listeDemandeOuvertureAValider= new ArrayList<DemandeOuverture>();

}

