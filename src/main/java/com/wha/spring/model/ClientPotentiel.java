package com.wha.spring.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ClientPotentiel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nom", nullable = false)
	private String nom;
	
	@Column(name = "Prenom", nullable = false)
	private String prenom;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "adresse", nullable = false)
	private String adresse;
	
	@Column(name = "telephone", nullable = false)
	private String telephone;
	
	@Column(name = "revenuMens", nullable = false)
	private Double revenuMens;
	
	@Column(name = "piecesJustif", nullable = false)
	private String piecesJustif;
	

}
