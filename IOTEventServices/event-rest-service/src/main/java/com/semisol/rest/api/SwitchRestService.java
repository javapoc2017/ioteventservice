package com.semisol.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.semisol.iot.dto.IotEventsDTO;
import com.semisol.service.api.SwitchService;

@RestController
@RequestMapping(value = "/v1/iot")
public class SwitchRestService {
	
	@Autowired
	private SwitchService switchService;
	
	@RequestMapping(value="/switch/operation",method=RequestMethod.POST)
	public void registerUser(@RequestBody IotEventsDTO iotEventsDTO) {
		switchService.updateSwitch(iotEventsDTO);
	}

}
