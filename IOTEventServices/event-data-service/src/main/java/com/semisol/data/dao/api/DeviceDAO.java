package com.semisol.data.dao.api;

import org.springframework.context.annotation.Configuration;

import com.semisol.data.domain.Device;

@Configuration
public interface DeviceDAO {
	boolean saveDeviceInfo(Device device);
}
