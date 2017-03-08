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

import com.semisol.iot.dto.LocationDTO;
import com.semisol.iot.dto.RestResponse;
import com.semisol.service.api.AdminService;

@RestController
@RequestMapping(value = "/admin/location")

public class LocationRestService {
	private static Logger logger = LoggerFactory.getLogger(LocationRestService.class);

	@Autowired
	private AdminService adminService;

	@RequestMapping(method = RequestMethod.POST)
	public RestResponse addLocation(@RequestBody LocationDTO locationDTO) {
		boolean status = adminService.addLocationInfo(locationDTO);
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(status);
		return restResponse;
	}

	@RequestMapping(method = RequestMethod.PUT)
	public RestResponse updateLocation(@RequestBody LocationDTO locationDTO) {
		boolean status = adminService.updateLocationInfo(locationDTO);
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(status);
		return restResponse;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<LocationDTO>> getAllLocations() {
		List<LocationDTO>	locations = adminService.getAllLocations();
		if (locations.isEmpty()) {
			logger.info("categories does not exists");
			return new ResponseEntity<List<LocationDTO>>(HttpStatus.NO_CONTENT);
		}
		logger.info("Found " + locations.size() + " Locations");
		return new ResponseEntity<List<LocationDTO>>(locations, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteLocation(@PathVariable("id") UUID id) {
		LocationDTO locationDTO = adminService.findLocationById(id);
		if (locationDTO == null) {
			logger.info("LocationDTO with id " + id + " does not exists");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			adminService.deleteLocationInfo(locationDTO);
			logger.info("LocationDTO with id " + id + " deleted");
			return new ResponseEntity<Void>(HttpStatus.GONE);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<LocationDTO> getLocationDetails(@PathVariable("id") UUID id) {
		LocationDTO locationDTO = adminService.findLocationById(id);
		if (locationDTO == null) {
			logger.info("LocationDTO with id " + id + " does not exists");
			return new ResponseEntity<LocationDTO>(HttpStatus.NOT_FOUND);
		}
		logger.info("Found LocationDTO:: " + locationDTO);
		return new ResponseEntity<LocationDTO>(locationDTO, HttpStatus.OK);
	}
}
