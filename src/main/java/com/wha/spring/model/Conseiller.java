package com.wha.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
	// cascade = { CascadeType.ALL }, fetch = FetchType.EAGER,
	@OneToMany(mappedBy = "conseiller")
	@JsonIgnore
	List<Client> listClient = new ArrayList<Client>();
	@OneToMany
	@JsonIgnore
	List<Requete> listeDemandeClients = new ArrayList<Requete>();

	@OneToMany
	@JsonIgnore
	List<DemandeOuverture> listeDemandeOuvertureAValider = new ArrayList<DemandeOuverture>();

	
	
	


	@Builder
	public Conseiller(int id, String nom, String prenom, String email,
			String adresse, String telephone, String pseudo, String mdp) {
		super(0,nom, prenom, email, adresse, telephone, pseudo, mdp);
		this.listClient = new ArrayList<Client>();
		this.listeDemandeClients = new ArrayList<Requete>();
		this.listeDemandeOuvertureAValider = new ArrayList<DemandeOuverture>();
	}
	
}
