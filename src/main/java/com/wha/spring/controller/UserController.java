package com.wha.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wha.spring.dto.LoginDTO;
import com.wha.spring.dto.UserDTO;
import com.wha.spring.dto.UserDTOHelp;
import com.wha.spring.iservice.LoginService;
import com.wha.spring.iservice.UserService;
import com.wha.spring.model.Administrateur;
import com.wha.spring.model.Client;
import com.wha.spring.model.Conseiller;
import com.wha.spring.model.User;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/create/dummy", method = RequestMethod.GET)
	public User dummy() {
		return null;
		/*
		 * User u1 = new User(0, "Jemal Ahmed", "Ahmed.Jemal",
		 * "jmlhmd@gmail.com"); User u2 = new User(0, "Leanne Graham", "Bret",
		 * "Sincere@april.biz"); User u3 = new User(0, "Clementina DuBuque",
		 * "Moriah.Stanton", "Rey.Padberg@karina.biz");
		 * userService.saveUser(u1); userService.saveUser(u2);
		 * userService.saveUser(u3);
		 */
		// Client cl=new Client();
		// cl.setAdresse("");

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/get/all", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAll() {
		List<User> resultat = userService.findAllUsers();
		return new ResponseEntity<List<User>>(resultat, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/create")
	public User createUser(@RequestBody User user) {
		User newUser = userService.saveUser(user);
		return newUser;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/update")
	public User updateUser(@RequestBody User user) {
		userService.updateUser(user);
		return user;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/login")
	//@RequestMapping(value = "/login", method = RequestMethod.GET)
	public UserDTO login(@RequestBody LoginDTO login) {

		UserDTO result = null;
		User user = loginService
				.login(login.getUsername(), login.getPassword());
		if (user instanceof Client) {
			result = UserDTOHelp.userToUserDTO(user, "Client");
		} else {
			if (user instanceof Administrateur) {
				result = UserDTOHelp.userToUserDTO(user, "Administrateur");
			} else {
				if (user instanceof Conseiller) {
					result = UserDTOHelp.userToUserDTO(user, "Conseiller");
				}
			}

		}
		return result;
	}
}
