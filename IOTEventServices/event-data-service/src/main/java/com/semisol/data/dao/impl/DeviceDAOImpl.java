package com.semisol.data.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.semisol.data.dao.api.DeviceDAO;
import com.semisol.data.domain.Device;
import com.semisol.data.repository.DeviceRepository;

@Configuration
public class DeviceDAOImpl implements DeviceDAO{
	
	@Autowired
	private DeviceRepository deviceRepository;

	

	public boolean saveDeviceInfo(Device device) {
		try{
			deviceRepository.save(device);
		}catch(Exception ex){
			return false;
		}
		return true;
	}

}
