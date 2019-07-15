package com.wha.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("Conseiller")
/*@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor*/
@Table(name = "Conseiller")
public class Conseiller extends User{
	
/*	List<Client> listsClient = new ArrayList<Client>();
	List<Requete> listeDemandeClients= new ArrayList<Client>();
	List<DemandeOuverture> listeDemandeOuvertureAValider= new ArrayList<Client>();*/
	
	

}

