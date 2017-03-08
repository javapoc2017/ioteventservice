package com.semisol.rest.api;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.semisol.iot.dto.OrganizationDTO;
import com.semisol.iot.dto.RestResponse;
import com.semisol.service.api.AdminService;

@RestController
@RequestMapping(value = "/admin/organization")
public class OrganizationRestService {
	private static Logger logger = LoggerFactory.getLogger(OrganizationRestService.class);

	@Autowired
	private AdminService adminService;

	@RequestMapping(method = RequestMethod.POST)
	public RestResponse addOrganization(@RequestBody OrganizationDTO organizationDTO) {
		boolean status = adminService.saveOrganizationInfo(organizationDTO);
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(status);
		return restResponse;
	}

	@RequestMapping(method = RequestMethod.PUT)
	public RestResponse updateOrganization(@RequestBody OrganizationDTO organizationDTO) {
		boolean status = adminService.updateOrganizationInfo(organizationDTO);
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(status);
		return restResponse;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<OrganizationDTO>> getAllOrganizations() {
		List<OrganizationDTO>	organizations = adminService.getAllOrganization();
		if (organizations.isEmpty()) {
			logger.debug("Organizations does not exists");
			return new ResponseEntity<List<OrganizationDTO>>(HttpStatus.NO_CONTENT);
		}
		logger.info("Found " + organizations.size() + " Organizations");
		return new ResponseEntity<List<OrganizationDTO>>(organizations, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteOrganization(@PathVariable("id") UUID id) {
		OrganizationDTO organizationDTO = adminService.findOrganizationById(id);
		if (organizationDTO == null) {
			logger.info("organizationDTO with id " + id + " does not exists");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			adminService.deleteOrganizationInfo(organizationDTO);
			logger.info("organizationDTO with id " + id + " deleted");
			return new ResponseEntity<Void>(HttpStatus.GONE);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<OrganizationDTO> getOrganizationDetails(@PathVariable("id") UUID id) {
		OrganizationDTO organizationDTO = adminService.findOrganizationById(id);
		if (organizationDTO == null) {
			logger.info("organizationDTO with id " + id + " does not exists");
			return new ResponseEntity<OrganizationDTO>(HttpStatus.NOT_FOUND);
		}
		logger.info("Found organizationDTO:: " + organizationDTO);
		return new ResponseEntity<OrganizationDTO>(organizationDTO, HttpStatus.OK);
	}

}
