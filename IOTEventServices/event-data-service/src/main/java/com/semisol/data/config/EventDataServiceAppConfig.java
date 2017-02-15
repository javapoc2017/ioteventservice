package com.semisol.data.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.semisol.data.dao.api.IotEventsDAO;
import com.semisol.data.dao.impl.IotEventsDAOImpl;

@Configuration
@ComponentScan(basePackages = { "com.semisol.data" })
public class EventDataServiceAppConfig {

	@Bean(name = "iotEventsDAO")
	public IotEventsDAO getEventDAO() {
		return new IotEventsDAOImpl();
	}
}
