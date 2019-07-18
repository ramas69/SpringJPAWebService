package com.wha.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("Client") 

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor 

@Table(name = "Client")
public class Client extends User {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private int identifiant;
	
	@JsonIgnore
	@OneToMany(mappedBy="client",fetch=FetchType.LAZY)
	private List<Compte> comptes;
	
	private double revenuMenus;
	private String piecesJustif;
	
	
	@ManyToOne
	private Conseiller conseiller;
	
	@JsonIgnore
	@OneToMany(mappedBy="client")
	private List<Requete> listeRequetes;
	
	 @Builder
	    public Client(int id,String nom, String prenom, String email, String adress, String telephone, String pseudo, String mdp, int identifiant, double revenuMenus, String piecesJustif ) {
	        super(0,nom, prenom, email, adress, telephone, pseudo, mdp);
	        this.identifiant= identifiant;
	        this.revenuMenus= revenuMenus;
	        this.piecesJustif= piecesJustif;
	        this.comptes = new ArrayList<Compte>();
	        this.listeRequetes = new ArrayList<Requete>();
	    }
	
 
}
