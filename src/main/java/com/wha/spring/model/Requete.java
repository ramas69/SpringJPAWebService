package com.wha.spring.model;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
/*@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor*/
public class Requete {
	
	private Client client;
	//private Compte compte;
	private String message;
	private TypeRequete type;

}
