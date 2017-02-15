package com.semisol.data.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.semisol.data.dao.api.DeviceDAO;
import com.semisol.data.repository.DeviceRepository;

@Configuration
public class DeviceDAOImpl implements DeviceDAO{
	
	@Autowired
	private DeviceRepository deviceRepository;

	

	public void saveDeviceInfo() {
		//deviceRepository.save(arg0);
	}

}
