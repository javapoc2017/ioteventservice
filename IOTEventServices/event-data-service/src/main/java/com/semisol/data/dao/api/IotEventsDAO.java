package com.semisol.data.dao.api;

import org.springframework.context.annotation.Configuration;

@Configuration
public interface IotEventsDAO {
	
	void saveEventsInfo(String message)  throws Exception;
	
	String getEventDataByDevice(String devId) throws ClassNotFoundException; 

}
