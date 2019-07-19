package com.wha.spring.dto;

import com.wha.spring.model.User;
import com.wha.spring.dto.UserDTO;;

public class UserDTOHelp {
	
	public static UserDTO userToUserDTO(User user, String userType){
		return new UserDTO(user.getId(), 
				user.getNom(), user.getPrenom(), user.getEmail(), user.getAdresse(), user.getTelephone() , userType);
		
	}

}
