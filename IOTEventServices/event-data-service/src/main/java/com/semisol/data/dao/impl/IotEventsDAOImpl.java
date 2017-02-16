package com.semisol.data.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import com.semisol.data.dao.api.IotEventsDAO;
import com.semisol.data.domain.IotEvents;
import com.semisol.data.repository.IotEventsRepository;

@Configuration
@EnableCassandraRepositories(basePackages = "com.semisol.data.repository")
public class IotEventsDAOImpl implements IotEventsDAO {

	@Autowired
	private IotEventsRepository iotEventsRepository;

	@Override
	public void saveEventsInfo(IotEvents iotEvents) throws Exception {
		iotEventsRepository.save(iotEvents);
	}

	@Override
	public IotEvents findLatestEventByDevice(String deviceId) throws Exception {
		return null;//  iotEventsRepository.findLatestEventByDevice(deviceId);
	}
}
