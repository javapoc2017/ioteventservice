package com.semisol.service.api;

import com.semisol.iot.dto.DeviceDTO;
import com.semisol.iot.dto.OrganizationDTO;

public interface  AdminService {
	
	boolean saveDeviceInfo(DeviceDTO deviceDTO);
	
	boolean updateUserDevice();
	
	boolean saveOrganizationInfo(OrganizationDTO organizationDTO);

}
