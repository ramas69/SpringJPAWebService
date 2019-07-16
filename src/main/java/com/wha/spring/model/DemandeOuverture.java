package com.wha.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
@Table(name = "DemandeOuverture")
public class DemandeOuverture {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

@OneToOne
private ClientPotentiel clientPotentiel;

@Column(name = "valide", nullable = false)
private boolean valide;

@ManyToOne
private Conseiller conseiller;


}
