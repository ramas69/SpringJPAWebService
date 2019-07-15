package com.wha.spring.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@Table(name = "Client")
public class Client extends User {
	@Id
	@GeneratedValue
	private int identifiant;
	//@OneToMany(mappedBy="client",fetch=FetchType.LAZY)
	//private List<Compte> comptes;
	private double revenuMenus;
	private String piecesJustif;
	//@JoinColumn(name="matricule")
	//@ManyToOne(mappedBy="client",fetch=FetchType.LAZY)
	//private Conseiller conseiller;
	
 
}
