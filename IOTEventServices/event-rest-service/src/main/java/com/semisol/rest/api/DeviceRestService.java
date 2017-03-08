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

import com.semisol.iot.dto.DeviceDTO;
import com.semisol.iot.dto.RestResponse;
import com.semisol.service.api.AdminService;

@RestController
@RequestMapping(value = "/admin/device")
public class DeviceRestService {
	private static Logger logger = LoggerFactory.getLogger(DeviceRestService.class);

	@Autowired
	private AdminService adminService;

	@RequestMapping(method = RequestMethod.POST)
	public RestResponse addDevice(@RequestBody DeviceDTO categoryDTO) {
		boolean status = adminService.saveDeviceInfo(categoryDTO);
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(status);
		return restResponse;
	}

	@RequestMapping(method = RequestMethod.PUT)
	public RestResponse updateDevice(@RequestBody DeviceDTO categoryDTO) {
		boolean status = adminService.updateDeviceInfo(categoryDTO);
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(status);
		return restResponse;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<DeviceDTO>> getAllDevices() {
		List<DeviceDTO>	devices = adminService.getAllDevices();
		if (devices.isEmpty()) {
			logger.debug("devices does not exists");
			return new ResponseEntity<List<DeviceDTO>>(HttpStatus.NO_CONTENT);
		}
		logger.info("Found " + devices.size() + " devices");
		return new ResponseEntity<List<DeviceDTO>>(devices, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteDevice(@PathVariable("id") UUID id) {
		DeviceDTO deviceDTO = adminService.findDeviceById(id);
		if (deviceDTO == null) {
			logger.info("DeviceDTO with id " + id + " does not exists");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			adminService.deleteDeviceInfo(deviceDTO);
			logger.info("DeviceDTO with id " + id + " deleted");
			return new ResponseEntity<Void>(HttpStatus.GONE);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<DeviceDTO> getDeviceDetails(@PathVariable("id") UUID id) {
		DeviceDTO deviceDTO = adminService.findDeviceById(id);
		if (deviceDTO == null) {
			logger.info("DeviceDTO with id " + id + " does not exists");
			return new ResponseEntity<DeviceDTO>(HttpStatus.NOT_FOUND);
		}
		logger.info("Found DeviceDTO:: " + deviceDTO);
		return new ResponseEntity<DeviceDTO>(deviceDTO, HttpStatus.OK);
	}
}
