package com.wha.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
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
public class Conseiller extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER, mappedBy = "conseiller")
	List<Client> listClient = new ArrayList<Client>();
	@OneToMany
	List<Requete> listeDemandeClients = new ArrayList<Requete>();

	@OneToMany
	List<DemandeOuverture> listeDemandeOuvertureAValider = new ArrayList<DemandeOuverture>();

}
