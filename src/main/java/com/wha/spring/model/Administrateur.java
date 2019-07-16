package com.wha.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("Administrateur")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Administrateur extends User{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToMany
	private List<Conseiller> listeConseillers;
	@OneToMany
	private List<DemandeOuverture> listeDemandeOuverture;
	
	@Builder
	public Administrateur(int id, String nom, String prenom, String email,
			String adresse, String telephone, String pseudo, String mdp) {
		super(id, nom, prenom, email, adresse, telephone, pseudo, mdp);
		// TODO Auto-generated constructor stub
		this.listeConseillers=new ArrayList<Conseiller>();
		this.listeDemandeOuverture=new ArrayList<DemandeOuverture>();
	}
	
	

}
