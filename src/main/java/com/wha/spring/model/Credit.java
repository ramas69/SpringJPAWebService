package com.wha.spring.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("Credit")
public class Credit extends Transaction{
	
	
}
