package com.TeamCalendarBackend.SpringBoot.controller;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.TeamCalendarBackend.SpringBoot.model.User;


public class UserController {
	
	
	
	
	@RequestMapping(value = "/users/signup", method = RequestMethod.POST)
	public ResponseEntity<Void> register(@RequestBody User form) {
		//logger.info("register success {}", form);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	

}
