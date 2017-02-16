package com.semisol.data.dao.api;

import org.springframework.context.annotation.Configuration;

import com.semisol.data.domain.IotEvents;

@Configuration
public interface IotEventsDAO {

	void saveEventsInfo(IotEvents iotEvents) throws Exception;

	IotEvents findLatestEventByDevice(String deviceId) throws Exception;

}
