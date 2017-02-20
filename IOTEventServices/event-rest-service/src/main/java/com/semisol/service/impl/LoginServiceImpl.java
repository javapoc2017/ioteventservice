package com.semisol.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semisol.data.dao.api.UserDAO;
import com.semisol.iot.dto.LoginDTO;
import com.semisol.iot.dto.RestResponse;
import com.semisol.iot.util.ConverterUtll;
import com.semisol.service.api.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserDAO userDAO;
	
	

	@Override
	public RestResponse validateUser(LoginDTO loginDTO) {
		RestResponse restResponse = new RestResponse();
		boolean status = userDAO.validateUser(ConverterUtll.convertDtoToDao(loginDTO));
		restResponse.setStatus(status);
		return restResponse;
	}

	@Override
	public RestResponse registerUser(LoginDTO loginDTO) {
		RestResponse restResponse = new RestResponse();
		boolean status = userDAO.saveUserInfo(ConverterUtll.convertDtoToDao(loginDTO));
		restResponse.setStatus(status);
		return restResponse;
	}

}
