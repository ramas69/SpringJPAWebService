package com.wha.spring.model;

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

import lombok.AllArgsConstructor;
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
	@OneToMany(mappedBy="client",fetch=FetchType.LAZY)
	private List<Compte> comptes;
	private double revenuMenus;
	private String piecesJustif;
	@ManyToOne
	private Conseiller conseiller;
	@OneToMany(mappedBy="client")
	private List<Requete> requete;
	
 
}
