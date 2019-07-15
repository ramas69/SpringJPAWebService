package com.wha.spring.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="user_type", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "User")
public class User {

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
	
	@Column(name = "pseudo", nullable = false)
	private String pseudo;
	
	@Column(name = "mdp", nullable = false)
	private String mdp;
	
	
	

	
}
