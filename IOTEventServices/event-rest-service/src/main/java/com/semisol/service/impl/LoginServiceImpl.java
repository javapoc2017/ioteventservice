package com.semisol.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semisol.data.dao.api.UserDAO;
import com.semisol.iot.dto.LoginDTO;
import com.semisol.iot.dto.LoginResponse;
import com.semisol.iot.util.LoginConverterUtll;
import com.semisol.service.api.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public LoginResponse validateUser(LoginDTO loginDTO) {
		LoginResponse loginResponse = new LoginResponse();
		boolean status = userDAO.validateUser(LoginConverterUtll.convertDtoToDao(loginDTO));
		loginResponse.setStatus(status);
		return loginResponse;
	}

	@Override
	public LoginResponse registerUser(LoginDTO loginDTO) {
		LoginResponse loginResponse = new LoginResponse();
		boolean status = userDAO.saveUserInfo(LoginConverterUtll.convertDtoToDao(loginDTO));
		loginResponse.setStatus(status);
		return loginResponse;
	}

}
