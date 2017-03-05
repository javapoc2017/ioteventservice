package com.semisol.service.api;

import com.semisol.iot.dto.CategoryDTO;
import com.semisol.iot.dto.DeviceDTO;
import com.semisol.iot.dto.GatewayDTO;
import com.semisol.iot.dto.LocationDTO;
import com.semisol.iot.dto.OrganizationDTO;

public interface AdminService {

	boolean saveCategoryInfo(CategoryDTO categoryDTO);

	boolean saveLocationInfo(LocationDTO locationDTO);

	boolean saveDeviceInfo(DeviceDTO deviceDTO);

	boolean saveGatewayInfo(GatewayDTO gatewayDTO);

	boolean saveOrganizationInfo(OrganizationDTO organizationDTO);

}
