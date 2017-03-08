package com.semisol.service.api;

import java.util.List;
import java.util.UUID;

import com.semisol.data.domain.Category;
import com.semisol.data.domain.Gateway;
import com.semisol.data.domain.Location;
import com.semisol.iot.dto.CategoryDTO;
import com.semisol.iot.dto.DeviceDTO;
import com.semisol.iot.dto.GatewayDTO;
import com.semisol.iot.dto.LocationDTO;
import com.semisol.iot.dto.OrganizationDTO;

public interface AdminService {

	// category
	boolean addCategoryInfo(CategoryDTO categoryDTO);

	boolean updateCategoryInfo(CategoryDTO categoryDTO);

	boolean deleteCategoryInfo(CategoryDTO categoryDTO);

	List<CategoryDTO> getAllCategories();

	CategoryDTO findCategoryById(UUID categoryId);

	// location
	boolean addLocationInfo(LocationDTO location);

	boolean updateLocationInfo(LocationDTO location);

	boolean deleteLocationInfo(LocationDTO location);

	List<LocationDTO> getAllLocations();

	LocationDTO findLocationById(UUID locationId);

	// gateway

	boolean addGatewayInfo(GatewayDTO gateway);

	boolean updateGatewayInfo(GatewayDTO gateway);

	boolean deleteGatewayInfo(GatewayDTO gateway);

	List<GatewayDTO> getAllGateways();

	GatewayDTO findGatewayById(UUID gatewayId);

	// device
	boolean saveDeviceInfo(DeviceDTO deviceDTO);

	public boolean updateDeviceInfo(DeviceDTO deviceDTO);

	public boolean deleteDeviceInfo(DeviceDTO deviceDTO);

	public List<DeviceDTO> getAllDevices();

	public DeviceDTO findDeviceById(UUID uuid);

	// organization
	boolean saveOrganizationInfo(OrganizationDTO organizationDTO);

	public boolean updateOrganizationInfo(OrganizationDTO organizationDTO);

	public boolean deleteOrganizationInfo(OrganizationDTO organizationDTO);

	public List<OrganizationDTO> getAllOrganization();

	public OrganizationDTO findOrganizationById(UUID uuid);
}
