package com.wha.spring.model;


import java.util.List;

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
@Table(name = "Compte")
public class Compte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "rib", nullable = false)
	private String rib;
	@Column(name = "solde", nullable = false)
	private double solde;
	@Column(name = "nom", nullable = false)
	private List<Transaction> listeTransactions;
	@Column(name = "nom", nullable = false)
	private double decouvert;
	@Column(name = "nom", nullable = false)
	private double mntantAgios;
	@Column(name = "nom", nullable = false)
	private double seuilRemuneration;
	private double montantRemuneration;
	//private List<Notification> listeNotification;
	
	
}
