package com.wha.spring.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clientPotentiel")
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
