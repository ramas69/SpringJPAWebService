package com.wha.spring.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
	
	//@Column(name = "nom", nullable = false)
	@OneToMany(mappedBy="compte")
	private List<Transaction> listeTransactions;
	
	@Column(name = "decouvert", nullable = false)
	private double decouvert;
	
	@Column(name = "mntantAgios", nullable = false)
	private double mntantAgios;
	
	@Column(name = "seuilRemuneration", nullable = false)
	private double seuilRemuneration;
	
	@Column(name = "montantRemuneration", nullable = false)
	private double montantRemuneration;
	
	@OneToMany(mappedBy="compte")
	private List<Notification> listeNotifications;
	
	
	private Client client;

@Builder
	public Compte(int id, String rib, String nCompte, double solde,
			double decouvert, double mntantAgios, double seuilRemuneration,
			double montantRemuneration, Client client) {
		//super();
		this.id = id;
		this.rib = rib;
		this.nCompte = nCompte;
		this.solde = solde;
		this.decouvert = decouvert;
		this.mntantAgios = mntantAgios;
		this.seuilRemuneration = seuilRemuneration;
		this.montantRemuneration = montantRemuneration;
	}

	
	
}
