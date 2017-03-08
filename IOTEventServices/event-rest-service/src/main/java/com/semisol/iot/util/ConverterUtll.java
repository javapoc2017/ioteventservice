package com.semisol.iot.util;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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
		device.setDevId(deviceDTO.getDevId() == null ? UUID.randomUUID():deviceDTO.getDevId());
		device.setName(deviceDTO.getName());
		device.setAttributes(deviceDTO.getAttributes());
		Calendar cal = Calendar.getInstance();
		device.setLastModified(new Timestamp(cal.getTimeInMillis()));
		device.setCatId(deviceDTO.getCatId());
		device.setgId(deviceDTO.getgId());
		device.setLocId(deviceDTO.getLocId());
		device.setStatus(deviceDTO.isStatus());
		return device;
	}

	public static Organization convertDtoToDao(OrganizationDTO organizationDTO) {
		Organization organization = new Organization();
		organization.setDescription(organizationDTO.getDescription());
		organization.setOrgId(organizationDTO.getOrgId() == null ? UUID.randomUUID():organizationDTO.getOrgId());
		organization.setName(organizationDTO.getName());
		Calendar cal = Calendar.getInstance();
		organization.setLastModified(new Timestamp(cal.getTimeInMillis()));
		organization.setStatus(organizationDTO.isStatus());
		return organization;

	}

	public static Category convertDtoToDao(CategoryDTO categoryDTO) {
		Category category = new Category();
		category.setCatId(categoryDTO.getCatId() == null ? UUID.randomUUID():categoryDTO.getCatId());
		category.setName(categoryDTO.getName());
		category.setDescription(categoryDTO.getDescription());
		Calendar cal = Calendar.getInstance();
		category.setLastModified(new Timestamp(cal.getTimeInMillis()));
		return category;

	}

	public static Location convertDtoToDao(LocationDTO locationDTO) {
		Location location = new Location();
		location.setDescription(locationDTO.getDescription());
		location.setLocId(locationDTO.getLocId() == null ? UUID.randomUUID():locationDTO.getLocId());
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
		gateway.setgId(gatewayDTO.getgId() == null ? UUID.randomUUID():gatewayDTO.getgId());
		gateway.setName(gatewayDTO.getName());
		gateway.setLocId(gatewayDTO.getLocId());
		gateway.setMacId(gatewayDTO.getMacId());
		gateway.setOrgId(gatewayDTO.getOrgId());
		Calendar cal = Calendar.getInstance();
		gateway.setLastModified(new Timestamp(cal.getTimeInMillis()));
		gateway.setStatus(gatewayDTO.isStatus());
		return gateway;

	}
	
	public static OrganizationDTO convertDaoToDto(Organization organization) {
		OrganizationDTO organizationDTO = new OrganizationDTO();
		organizationDTO.setOrgId(organization.getOrgId());
		organizationDTO.setName(organization.getName());
		organizationDTO.setDescription(organization.getDescription());
		organizationDTO.setStatus(organization.isStatus());
		return organizationDTO;
	}
	
	public static LocationDTO convertDaoToDto(Location location) {
		LocationDTO locationDTO = new LocationDTO();
		locationDTO.setName(location.getName());
		locationDTO.setLatitude(location.getLatitude());
		locationDTO.setLongitude(location.getLongitude());
		locationDTO.setDescription(location.getDescription());
		return locationDTO;
	}

	public static DeviceDTO convertDaoToDto(Device device) {
		DeviceDTO deviceDTO = new DeviceDTO();
		deviceDTO.setDevId(device.getDevId());
		deviceDTO.setName(device.getName());
		deviceDTO.setMacId(device.getMacId());
		deviceDTO.setCatId(device.getCatId());
		deviceDTO.setgId(device.getgId());
		deviceDTO.setAttributes(device.getAttributes());
		deviceDTO.setLastModified(device.getLastModified());
		deviceDTO.setStatus(device.isStatus());
		return deviceDTO;
	}
	
	public static GatewayDTO convertDaoToDto(Gateway gateway) {
		 GatewayDTO  gatewayDTO = new GatewayDTO();
		 gatewayDTO.setLocId(gateway.getLocId());
		 gatewayDTO.setName(gateway.getName());
		 gatewayDTO.setOrgId(gateway.getOrgId());
		 gatewayDTO.setMacId(gateway.getMacId());
		 gatewayDTO.setDescription(gateway.getDescription());
		 gatewayDTO.setStatus(gateway.isStatus());
		return gatewayDTO;

	}
	
	public static CategoryDTO convertDaoToDto(Category category) {
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setCatId(category.getCatId());
		categoryDTO.setName(category.getName());
		categoryDTO.setDescription(category.getDescription());
		return categoryDTO;
	}
}
