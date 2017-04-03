package com.semisol.rest.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.semisol.iot.dto.LoginDTO;
import com.semisol.iot.dto.RestResponse;
import com.semisol.monitor.security.TokenUtils;
import com.semisol.service.api.LoginService;

@RestController
@RequestMapping(value = "v1/iot")
public class LoginRestService {
	private static Logger logger = LoggerFactory.getLogger(LoginRestService.class);

	@Autowired
	private LoginService loginService;
	
	@Autowired
	  private AuthenticationManager authenticationManager;

	  @Autowired
	  private TokenUtils tokenUtils;

	  @Autowired
	  private UserDetailsService userDetailsService;

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public RestResponse registration(@RequestBody LoginDTO loginDTO) {
		logger.info("LoginRestService:saveUser,request" + loginDTO);
		RestResponse restResponse = loginService.registerUser(loginDTO);
		logger.info("LoginRestService:saveUser,response" + restResponse);
		return restResponse;
	}

	@RequestMapping(value = "/customer/login", method = RequestMethod.POST)
	public ResponseEntity<?> validateLogin(@RequestBody LoginDTO loginDTO, Device device) {
		logger.info("LoginRestService:validateLogin,request" + loginDTO);
		//RestResponse restResponse = loginService.validateUser(loginDTO);
		//logger.info("LoginRestService:validateLogin,response" + restResponse);
		// Perform the authentication
	    Authentication authentication = this.authenticationManager.authenticate(
	      new UsernamePasswordAuthenticationToken(
	    		  loginDTO.getUsername(),
	    		  loginDTO.getPassword()
	      )
	    );
	    SecurityContextHolder.getContext().setAuthentication(authentication);

	    // Reload password post-authentication so we can generate token
	    UserDetails userDetails = this.userDetailsService.loadUserByUsername(loginDTO.getUsername());
	    String token = this.tokenUtils.generateToken(userDetails, device);

	    // Return the token
	    return ResponseEntity.ok(new RestResponse(token,true));
	  
	}

	/*
	 * @RequestMapping(value="/customer/logout",method=RequestMethod.GET)
	 * 
	 * @ResponseStatus(HttpStatus.NO_CONTENT) public RestResponse
	 * logout(HttpSession session) {
	 * logger.info("LoginRestService:validateLogin,request"+loginDTO);
	 * RestResponse restResponse = loginService.validateUser(loginDTO);
	 * logger.info("LoginRestService:validateLogin,response"+restResponse);
	 * return restResponse; }
	 */

}
