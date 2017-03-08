package com.semisol.data.dao.api;

import org.springframework.context.annotation.Configuration;

import com.semisol.data.domain.DeviceEvent;

@Configuration
public interface DeviceEventsDAO {
	void saveEventsInfo(DeviceEvent deviceEvent) throws Exception;
	DeviceEvent findLatestEventByDevice(String devId) throws Exception;
}
