package com.wha.spring.model;

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
@Table(name = "Demande")
public class DemandeOuverture {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private ClientPotentiel clientPotentiel;

@Column(name = "valide", nullable = false)
private String valide;
private Conseiller conseiller;


}
