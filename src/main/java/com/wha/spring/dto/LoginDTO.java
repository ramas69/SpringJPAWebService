package com.wha.spring.dto;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;

import com.wha.spring.model.Client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginDTO {
	
	private String username;
	private String password;

}
