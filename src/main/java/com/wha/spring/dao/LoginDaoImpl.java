package com.wha.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.idao.LoginDao;
import com.wha.spring.model.Administrateur;
import com.wha.spring.model.Client;
import com.wha.spring.model.Conseiller;
import com.wha.spring.model.User;


@Repository("loginDao")
@Transactional
public class LoginDaoImpl extends AbstractDao implements LoginDao  {

	@Override
	public User login(String username, String password) {
//	return	 (User) em.createNativeQuery("From user where pseudo= "+username+" and mdp = "+password).setParameter(1, username).setParameter(2, password).getSingleResult();
		//return null;
	User user = new User();
		  String userType = (String) em.createNativeQuery(
	                "select user_type from user  where pseudo=? and mdp=?").setParameter(1, username).setParameter(2, password)
	                .getSingleResult();
		  
		  switch (userType) {
	        case "Administrateur":{
	            Administrateur admin = (Administrateur) em
	                    .createQuery(
	                            "From Administrateur u where u.pseudo= :username and u.mdp=:password")
	                    .setParameter("username", username)
	                    .setParameter("password", password).getSingleResult();
	            user = (User) admin;
	            break;
	         }
	        case "Conseiller":{
	            Conseiller conseiller = (Conseiller) em
	                    .createQuery(
	                            "From Conseiller u where u.pseudo= :username and u.mdp=:password")
	                    .setParameter("username", username)
	                    .setParameter("password", password).getSingleResult();
	            
	            user = (User) conseiller;
	            break;
	            }
	        
	        case "Client":{
	            Client client = (Client) em
	                    .createQuery(
	                            "From Client u where u.pseudo= :username and u.mdp=:password")
	                    .setParameter("username", username)
	                    .setParameter("password", password).getSingleResult();
	            user= (User) client;
	            break;
	        }
	        default:
	        	break;
		  }
		  
		  return user;
	}
}
