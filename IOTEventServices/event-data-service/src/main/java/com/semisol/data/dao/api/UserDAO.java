package com.semisol.data.dao.api;

import org.springframework.context.annotation.Configuration;

import com.semisol.data.domain.User;

@Configuration
public interface UserDAO {

	boolean saveUserInfo(User user);

	boolean validateUser(User user);
	
	User validateUser(String userName);

	boolean checkUserExists(User user);

}
