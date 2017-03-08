package com.semisol.data.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import com.semisol.data.dao.api.DeviceEventsDAO;
import com.semisol.data.domain.DeviceEvent;
import com.semisol.data.repository.DeviceEventsRepository;

@Configuration
@EnableCassandraRepositories(basePackages = "com.semisol.data.repository")
public class DeviceEventsDAOImpl implements DeviceEventsDAO {

	@Autowired
	private DeviceEventsRepository deviceEventsRepository;

	@Override
	public void saveEventsInfo(DeviceEvent deviceEvent) throws Exception {
		deviceEventsRepository.save(deviceEvent);
	}

	@Override
	public DeviceEvent findLatestEventByDevice(String devId) throws Exception {
		return deviceEventsRepository.findLatestEventByDevice(devId);
	}
}
