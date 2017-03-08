package com.semisol.data.dao.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.semisol.data.dao.api.DeviceDAO;
import com.semisol.data.domain.Device;
import com.semisol.data.repository.DeviceRepository;

@Configuration
public class DeviceDAOImpl implements DeviceDAO {

	@Autowired
	private DeviceRepository deviceRepository;

	public boolean saveDeviceInfo(Device device) {
		try {
			deviceRepository.save(device);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	@Override
	public boolean updateDeviceInfo(Device device) {
		try {
		//	deviceRepository.update(device);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteDeviceInfo(Device device) {
		try {
			deviceRepository.delete(device);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	@Override
	public List<Device> getAllDevices() {
		return (List<Device>) deviceRepository.findAll();
	}

	@Override
	public Device findDeviceById(UUID devId) {
		return deviceRepository.findByDevId(devId);
	}

}
