package com.semisol.data.dao.api;

import java.util.List;
import java.util.UUID;

import org.springframework.context.annotation.Configuration;

import com.semisol.data.domain.Device;

@Configuration
public interface DeviceDAO {

	boolean saveDeviceInfo(Device device);

	boolean updateDeviceInfo(Device device);

	boolean deleteDeviceInfo(Device device);

	List<Device> getAllDevices();

	Device findDeviceById(UUID devId);
}
