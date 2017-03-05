package com.semisol.service.api;

import com.semisol.iot.dto.DeviceEventsDTO;

public interface SwitchService {
	
	boolean updateSwitch(DeviceEventsDTO iotEventsDTO);

}
