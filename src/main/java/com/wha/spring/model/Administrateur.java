package com.wha.spring.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("Administrateur")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Administrateur extends User{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToMany
	private List<Conseiller> listeConseilleir;
	@OneToMany
	private List<DemandeOuverture> listeDemandeOuverture;
	

}
