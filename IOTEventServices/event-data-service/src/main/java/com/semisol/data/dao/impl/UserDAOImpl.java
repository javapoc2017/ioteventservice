package com.semisol.data.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.semisol.data.dao.api.UserDAO;
import com.semisol.data.domain.User;
import com.semisol.data.repository.UserRepository;
import com.semisol.data.util.PasswordUtil;

@Configuration
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	private UserRepository userRepository;

	

	public boolean saveUserInfo(User user) {
		try{
			user.setPassword(PasswordUtil.getEncryptedPassword(user.getPassword()));
		    userRepository.save(user);
		}catch(Exception ex){
			return false;
		}
		return true;
	}



	@Override
	public boolean validateUser(User user) {
		try{
			  userRepository.verifyUserCredentials(user.getUsername(),PasswordUtil.getEncryptedPassword(user.getPassword()));
			  
			}catch(Exception ex){
				return false;
			}
		return false;
	}

}
