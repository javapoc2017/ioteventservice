package com.semisol.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semisol.data.dao.api.UserDAO;
import com.semisol.data.domain.User;
import com.semisol.iot.dto.Errors;
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
		boolean status = false;
		User user = ConverterUtll.convertDtoToDao(loginDTO);
		if (!userDAO.checkUserExists(user)) {
			status = userDAO.saveUserInfo(ConverterUtll.convertDtoToDao(loginDTO));
			restResponse.setStatus(status);
		} else {
			restResponse.setStatus(status);
			Errors error = new Errors();
			error.setErrorMessage("User exists..Try with new User");
			error.setErrorType("User exists");
			List<Errors> list = new ArrayList<>();
			list.add(error);
			restResponse.setError(list);
		}
		return restResponse;
	}

}
