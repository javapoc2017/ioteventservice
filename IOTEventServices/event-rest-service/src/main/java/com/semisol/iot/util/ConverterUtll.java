package com.semisol.iot.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.semisol.data.dao.impl.UserDAOImpl;
import com.semisol.data.domain.Device;
import com.semisol.data.domain.IotEvents;
import com.semisol.data.domain.Organization;
import com.semisol.data.domain.User;
import com.semisol.iot.dto.DeviceDTO;
import com.semisol.iot.dto.LoginDTO;
import com.semisol.iot.dto.OrganizationDTO;

public class ConverterUtll {
	private static Logger logger = LoggerFactory.getLogger(ConverterUtll.class);

	public static User convertDtoToDao(LoginDTO loginDTO){
		Calendar cal=Calendar.getInstance();
		User user= new User();
		user.setEmail(loginDTO.getEmail());
		user.setFirst_name(loginDTO.getFirst_name());
		user.setLast_name(loginDTO.getLast_name());
		user.setMobileno(loginDTO.getMobileno());
		user.setOrgid(loginDTO.getOrgid());
		user.setPassword(loginDTO.getPassword());
		user.getDevice().addAll(loginDTO.getDevice());
		user.setUpdated_time(new Timestamp(cal.getTimeInMillis()));
		user.setUserid(UUID.randomUUID());
		user.setUsername(loginDTO.getUsername());
		return user;
	}
	
	public static Device convertDtoToDao(DeviceDTO deviceDTO){
		Device device = new Device();
		device.setDev_macid(deviceDTO.getDev_macid());
		device.setDevid(UUID.randomUUID());
		device.setDevname(deviceDTO.getDevname());
		device.setAttributes(deviceDTO.getAttributes());
		Calendar cal=Calendar.getInstance();
		device.setUpdated_time(new Timestamp(cal.getTimeInMillis()));
		return device;
	}
	
	public static Organization convertDtoToDao(OrganizationDTO organizationDTO){
		Organization organization=new Organization();
		organization.setDescription(organizationDTO.getDescription());
		organization.setOrgid(UUID.randomUUID());
		organization.setOrgname(organizationDTO.getOrgname());
		Calendar cal=Calendar.getInstance();
		organization.setUpdated_time(new Timestamp(cal.getTimeInMillis()));
		return organization;
		
	}

}
