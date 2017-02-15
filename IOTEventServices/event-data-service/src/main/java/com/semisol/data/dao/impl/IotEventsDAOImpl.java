package com.semisol.data.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.semisol.data.dao.api.IotEventsDAO;
import com.semisol.data.repository.IotEventsRepository;

@Configuration
public class IotEventsDAOImpl implements IotEventsDAO {
	
	@Autowired
	private IotEventsRepository iotEventsRepository;

	public void saveEventsInfo() {
		// TODO Auto-generated method stub

	}

}
