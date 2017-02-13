package com.semisol.data.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.semisol.data.dao.api.LoginDAO;
import com.semisol.data.domain.Login;
import com.semisol.data.repository.LoginRepository;

public class LoginDAOImpl implements LoginDAO {
	
	@Autowired
	LoginRepository loginRespo;

	//@Override
	public void addUser() {
		Login login =new Login();
		loginRespo.save(login);
		
	}

}
