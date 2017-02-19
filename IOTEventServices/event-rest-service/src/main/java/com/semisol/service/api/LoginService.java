package com.semisol.service.api;

import com.semisol.iot.dto.LoginDTO;
import com.semisol.iot.dto.LoginResponse;

public interface LoginService {
	
	LoginResponse validateUser(LoginDTO loginDTO);
	
	LoginResponse registerUser(LoginDTO loginDTO);
	

}
