package com.semisol.rest.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.semisol.iot.dto.LoginDTO;
import com.semisol.iot.dto.LoginResponse;
import com.semisol.service.api.LoginService;

@RestController
@RequestMapping(value = "/v1/iot")
public class LoginRestService {
	private static Logger logger = LoggerFactory.getLogger(LoginRestService.class);
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/customer/registerUser",method=RequestMethod.POST)
	public LoginResponse registration(@RequestBody LoginDTO loginDTO) {
		logger.info("LoginRestService:saveUser,request"+loginDTO);
		LoginResponse loginResponse = loginService.registerUser(loginDTO);
		logger.info("LoginRestService:saveUser,response"+loginResponse);
	    return loginResponse;
	}
	@RequestMapping(value="/customer/validate",method=RequestMethod.POST)
	public LoginResponse validateLogin(@RequestBody LoginDTO loginDTO) {
		logger.info("LoginRestService:validateLogin,request"+loginDTO);
		LoginResponse loginResponse = loginService.validateUser(loginDTO);
		logger.info("LoginRestService:validateLogin,response"+loginResponse);
		return loginResponse;
	}

}
