package com.semisol.rest.api;

import java.util.Arrays;
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

import com.semisol.iot.dto.GatewayDTO;
import com.semisol.iot.dto.RestResponse;
import com.semisol.service.api.AdminService;

@RestController
@RequestMapping(value = "/admin/gateway")

public class GatewayRestService {
	private static Logger logger = LoggerFactory.getLogger(GatewayRestService.class);

	@Autowired
	private AdminService adminService;

	@RequestMapping(method = RequestMethod.POST)
	public RestResponse addGateway(@RequestBody GatewayDTO gatewayDTO) {
		boolean status = adminService.addGatewayInfo(gatewayDTO);
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(status);
		return restResponse;
	}

	@RequestMapping(method = RequestMethod.PUT)
	public RestResponse updateGateway(@RequestBody GatewayDTO gatewayDTO) {
		boolean status = adminService.updateGatewayInfo(gatewayDTO);
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(status);
		return restResponse;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<GatewayDTO>> getAllGateways() {
		List<GatewayDTO> gateways = adminService.getAllGateways();
		if (gateways.isEmpty()) {
			logger.info("gateways does not exists");
			return new ResponseEntity<List<GatewayDTO>>(HttpStatus.NO_CONTENT);
		}
		logger.info("Found size:{} and {} ",gateways.size(),Arrays.toString(gateways.toArray()));
		return new ResponseEntity<List<GatewayDTO>>(gateways, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteGateway(@PathVariable("id") UUID id) {
		GatewayDTO gatewayDTO = adminService.findGatewayById(id);
		if (gatewayDTO == null) {
			logger.info("GatewayDTO with id " + id + " does not exists");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			adminService.deleteGatewayInfo(gatewayDTO);
			logger.info("GatewayDTO with id " + id + " deleted");
			return new ResponseEntity<Void>(HttpStatus.GONE);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<GatewayDTO> getGatewayDetails(@PathVariable("id") UUID id) {
		GatewayDTO gatewayDTO= adminService.findGatewayById(id);
		if (gatewayDTO == null) {
			logger.info("GatewayDTO with id " + id + " does not exists");
			return new ResponseEntity<GatewayDTO>(HttpStatus.NOT_FOUND);
		}
		logger.info("Found GatewayDTO:: " + gatewayDTO);
		return new ResponseEntity<GatewayDTO>(gatewayDTO, HttpStatus.OK);
	}
}
