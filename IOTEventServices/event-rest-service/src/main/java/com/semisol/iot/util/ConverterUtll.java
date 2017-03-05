package com.semisol.iot.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.UUID;

import com.semisol.data.domain.Category;
import com.semisol.data.domain.Device;
import com.semisol.data.domain.Gateway;
import com.semisol.data.domain.Location;
import com.semisol.data.domain.Organization;
import com.semisol.data.domain.User;
import com.semisol.iot.dto.CategoryDTO;
import com.semisol.iot.dto.DeviceDTO;
import com.semisol.iot.dto.GatewayDTO;
import com.semisol.iot.dto.LocationDTO;
import com.semisol.iot.dto.LoginDTO;
import com.semisol.iot.dto.OrganizationDTO;

public class ConverterUtll {

	public static User convertDtoToDao(LoginDTO loginDTO) {
		Calendar cal = Calendar.getInstance();
		User user = new User();
		user.setEmail(loginDTO.getEmail());
		user.setFirstName(loginDTO.getFirsName());
		user.setLastName(loginDTO.getLasName());
		user.setMobileNo(loginDTO.getMobileNo());
		user.setOrgId(loginDTO.getOrgId());
		user.setPassword(loginDTO.getPassword());
		user.getDevice().addAll(loginDTO.getDevice());
		user.setLastModified(new Timestamp(cal.getTimeInMillis()));
		user.setUserId(UUID.randomUUID());
		user.setUserName(loginDTO.getUsername());
		user.setgId(loginDTO.getgId());
		user.setStatus(loginDTO.isStatus());
		return user;
	}

	public static Device convertDtoToDao(DeviceDTO deviceDTO) {
		Device device = new Device();
		device.setMacId(deviceDTO.getMacId());
		device.setDevId(UUID.randomUUID());
		device.setName(deviceDTO.getName());
		device.setAttributes(deviceDTO.getAttributes());
		Calendar cal = Calendar.getInstance();
		device.setLastModified(new Timestamp(cal.getTimeInMillis()));
		device.setCatId(deviceDTO.getCatId());
		device.setgId(deviceDTO.getgId());
		device.setStatus(deviceDTO.isStatus());
		return device;
	}

	public static Organization convertDtoToDao(OrganizationDTO organizationDTO) {
		Organization organization = new Organization();
		organization.setDescription(organizationDTO.getDescription());
		organization.setOrgId(UUID.randomUUID());
		organization.setName(organizationDTO.getName());
		Calendar cal = Calendar.getInstance();
		organization.setLastModified(new Timestamp(cal.getTimeInMillis()));
		organization.setStatus(organizationDTO.isStatus());
		return organization;

	}

	public static Category convertDtoToDao(CategoryDTO categoryDTO) {
		Category category = new Category();
		category.setCatId(UUID.randomUUID());
		category.setName(categoryDTO.getName());
		category.setDescription(categoryDTO.getDescription());
		Calendar cal = Calendar.getInstance();
		category.setLastModified(new Timestamp(cal.getTimeInMillis()));
		return category;

	}

	public static Location convertDtoToDao(LocationDTO locationDTO) {
		Location location = new Location();
		location.setDescription(locationDTO.getDescription());
		location.setLocId(UUID.randomUUID());
		location.setName(locationDTO.getName());
		location.setLatitude(locationDTO.getLatitude());
		location.setLongitude(locationDTO.getLongitude());
		Calendar cal = Calendar.getInstance();
		location.setLastModified(new Timestamp(cal.getTimeInMillis()));
		location.setStatus(locationDTO.isStatus());
		return location;

	}
	
	public static Gateway convertDtoToDao(GatewayDTO gatewayDTO) {
		Gateway gateway = new Gateway();
		gateway.setDescription(gatewayDTO.getDescription());
		gateway.setgId(UUID.randomUUID());
		gateway.setName(gatewayDTO.getName());
		gateway.setLocId(gatewayDTO.getLocId());
		gateway.setMacId(gatewayDTO.getMacId());
		gateway.setOrgId(gatewayDTO.getOrgId());
		Calendar cal = Calendar.getInstance();
		gateway.setLastModified(new Timestamp(cal.getTimeInMillis()));
		gateway.setStatus(gatewayDTO.isStatus());
		return gateway;

	}

}
