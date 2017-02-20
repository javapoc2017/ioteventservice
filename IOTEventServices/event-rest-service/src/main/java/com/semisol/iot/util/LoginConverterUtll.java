package com.semisol.iot.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.UUID;

import com.semisol.data.domain.User;
import com.semisol.iot.dto.LoginDTO;

public class LoginConverterUtll {
	
	public static User convertDtoToDao(LoginDTO loginDTO){
		Calendar cal=Calendar.getInstance();
		User user= new User();
		user.setEmail(loginDTO.getEmail());
		user.setFirst_name(loginDTO.getFirst_name());
		user.setLast_name(loginDTO.getLast_name());
		user.setMobileno(loginDTO.getMobileno());
		user.setOrgid(loginDTO.getOrgid());
		user.setPassword(loginDTO.getPassword());
		user.setDevice(loginDTO.getDevice());
		user.setUpdated_time(new Timestamp(cal.getTimeInMillis()));
		user.setUserid(UUID.randomUUID());
		user.setUsername(loginDTO.getUsername());
		return user;
	}

}
