package com.semisol.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.semisol.service.api.LoginService;

@RestController
public class LoginRestService {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public void saveUser(@RequestParam String username ,@RequestParam String password) {
		 loginService.validateUser(username, password);;
	}

}
