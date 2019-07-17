package com.wha.spring.model;

import java.util.Calendar;


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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="transaction_type", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("Transaction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Transaction")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int transactionId;
	@Column(name = "montant", nullable = false)
	private double montant;

	@ManyToOne
	private Compte compte;

	@Column(name = "libelle", nullable = false)
	private String libelle;

	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date", nullable = false)
    private Calendar date;

}
