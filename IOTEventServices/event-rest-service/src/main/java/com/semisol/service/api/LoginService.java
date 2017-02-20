package com.semisol.service.api;

import com.semisol.iot.dto.LoginDTO;
import com.semisol.iot.dto.RestResponse;

public interface LoginService {
	
	RestResponse validateUser(LoginDTO loginDTO);
	
	RestResponse registerUser(LoginDTO loginDTO);
	

}
