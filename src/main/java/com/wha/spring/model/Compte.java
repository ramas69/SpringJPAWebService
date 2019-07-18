package com.wha.spring.model;


//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
//import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "Compte")
public class Compte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "rib", nullable = false)
	private String rib;
	
	@Column(name = "nCompte", nullable = false)
	private String nCompte;
	
	@Column(name = "solde", nullable = false)
	private double solde;
	
	
	@Column(name = "decouvert", nullable = false)
	private double decouvert;
	
	@Column(name = "mntantAgios", nullable = false)
	private double mntantAgios;
	
	@Column(name = "seuilRemuneration", nullable = false)
	private double seuilRemuneration;
	
	@Column(name = "montantRemuneration", nullable = false)
	private double montantRemuneration;
	
	
	@ManyToOne
	private Client client;
	
	@Column(name="gele")
	private boolean gele;


	
	
}
