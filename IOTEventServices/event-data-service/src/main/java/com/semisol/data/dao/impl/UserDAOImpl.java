package com.semisol.data.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.semisol.data.dao.api.UserDAO;
import com.semisol.data.repository.UserRepository;

@Configuration
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	private UserRepository userRepository;

	

	public void saveUserInfo() {
		// TODO Auto-generated method stub
		
	}

}
