package com.semisol.data.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.semisol.data.dao.api.UserDAO;
import com.semisol.data.domain.User;
import com.semisol.data.repository.UserRepository;
import com.semisol.data.util.PasswordUtil;

@Configuration
public class UserDAOImpl implements UserDAO {
	private static Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	@Autowired
	private UserRepository userRepository;

	public boolean saveUserInfo(User user) {
		try {
			user.setPassword(PasswordUtil.getEncryptedPassword(user.getPassword()));
			userRepository.save(user);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	@Override
	public boolean validateUser(User user) {
		try {
			logger.info("UserDAOImpl:validateUser" + user);
			User userData = userRepository.verifyUserCredentials(user.getUserName());
			if (userData.getPassword().equals(PasswordUtil.getEncryptedPassword(user.getPassword()))) {
				return true;
			}
		} catch (Exception ex) {
			logger.info("UserDAOImpl:validateUser,exception" + ex.getMessage());
			return false;
		}
		return false;
	}

	@Override
	public boolean checkUserExists(User user) {
		try {
			Integer result = userRepository.verifyUserID(user.getUserName());
			logger.info("UserDAOImpl:checkUserExists" + result);
			if (result == 1) {
				return true;
			}
		} catch (Exception ex) {
			return false;
		}
		return false;
	}

}
