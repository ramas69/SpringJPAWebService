package com.wha.spring.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Debit")
public class Debit extends Transaction{

}
