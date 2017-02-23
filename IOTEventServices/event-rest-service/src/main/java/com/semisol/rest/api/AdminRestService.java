package com.semisol.rest.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.semisol.iot.dto.DeviceDTO;
import com.semisol.iot.dto.RestResponse;
import com.semisol.iot.dto.OrganizationDTO;
import com.semisol.service.api.AdminService;

@RestController
@RequestMapping(value = "/v1/iot")
public class AdminRestService {
	private static Logger logger = LoggerFactory.getLogger(AdminRestService.class);

	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "/admin/device", method = RequestMethod.POST)
	public RestResponse addDevice(@RequestBody DeviceDTO deviceDTO) {
		logger.info("AdminRestService:addDevice,request" + deviceDTO);
		boolean status = adminService.saveDeviceInfo(deviceDTO);
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(status);
		logger.info("AdminRestService:addDevice,response" + restResponse);
		return restResponse;
	}

	@RequestMapping(value = "/admin/org", method = RequestMethod.POST)
	public RestResponse addOrganization(@RequestBody OrganizationDTO organizationDTO) {
		logger.info("AdminRestService:addOrganization,request" + organizationDTO);
		boolean status = adminService.saveOrganizationInfo(organizationDTO);
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(status);
		logger.info("AdminRestService:addOrganization,response" + restResponse);
		return restResponse;
	}

	// Need to work on this..
	@RequestMapping(value = "/admin/user/device", method = RequestMethod.POST)
	public RestResponse updateDeviceInfo(@RequestBody OrganizationDTO organizationDTO) {
		logger.info("AdminRestService:addOrganization,request" + organizationDTO);
		boolean status = adminService.saveOrganizationInfo(organizationDTO);
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(status);
		logger.info("AdminRestService:addOrganization,response" + restResponse);
		return restResponse;
	}

}
