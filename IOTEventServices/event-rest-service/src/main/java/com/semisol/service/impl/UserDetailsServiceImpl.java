package com.semisol.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.semisol.data.dao.api.UserDAO;
import com.semisol.data.domain.User;
import com.semisol.iot.dto.LoginDTO;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserDAO userDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userDAO.validateUser(username);
	
	    if (user == null) {
	      throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
	    } else {
	      return create(user);
	    }
	}

	private  static UserDetails create(User user) {
		LoginDTO  loginDTO= new LoginDTO();
		//loginDTO.setAccountNonLocked(false);
		loginDTO.setUsername(user.getUserName());
		loginDTO.setPassword(user.getPassword());
		loginDTO.setEmail( user.getEmail());
		loginDTO.setLastPasswordReset(null);
		loginDTO.setAuthorities( AuthorityUtils.commaSeparatedStringToAuthorityList("USER,ADMIN"));
	   
		return loginDTO;
	  }
 
}
