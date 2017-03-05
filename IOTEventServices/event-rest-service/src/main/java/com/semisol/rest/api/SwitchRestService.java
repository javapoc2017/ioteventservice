package com.semisol.rest.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.semisol.iot.dto.DeviceEventsDTO;
import com.semisol.service.api.SwitchService;

@RestController
@RequestMapping(value = "/v1/iot")
public class SwitchRestService {
	private static Logger logger = LoggerFactory.getLogger(SwitchRestService.class);
	
	@Autowired
	private SwitchService switchService;
	
	@RequestMapping(value="/switch/operation",method=RequestMethod.POST)
	public void registerUser(@RequestBody DeviceEventsDTO iotEventsDTO) {
		logger.info("LoginRestService:validateLogin,request"+iotEventsDTO);
		 switchService.updateSwitch(iotEventsDTO);
		logger.info("LoginRestService:validateLogin,response:processed");
	}

}
