package com.semisol.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semisol.data.dao.api.CategoryDAO;
import com.semisol.data.dao.api.DeviceDAO;
import com.semisol.data.dao.api.GatewayDAO;
import com.semisol.data.dao.api.LocationDAO;
import com.semisol.data.dao.api.OrganizationDAO;
import com.semisol.data.domain.Category;
import com.semisol.data.domain.Device;
import com.semisol.data.domain.Gateway;
import com.semisol.data.domain.Location;
import com.semisol.data.domain.Organization;
import com.semisol.iot.dto.CategoryDTO;
import com.semisol.iot.dto.DeviceDTO;
import com.semisol.iot.dto.GatewayDTO;
import com.semisol.iot.dto.LocationDTO;
import com.semisol.iot.dto.OrganizationDTO;
import com.semisol.iot.util.ConverterUtll;
import com.semisol.service.api.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	/*@Autowired
	private AdminDAO adminDAO;
	*/
	@Autowired
	private OrganizationDAO organizationDAO;
	
	@Autowired
	private DeviceDAO deviceDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private LocationDAO locationDAO;

	@Autowired
	private GatewayDAO gatewayDAO;
	
	@Override
	public boolean addCategoryInfo(CategoryDTO categoryDTO) {
		return categoryDAO.addCategoryInfo(ConverterUtll.convertDtoToDao(categoryDTO));
	}

	@Override
	public boolean updateCategoryInfo(CategoryDTO categoryDTO) {
		return categoryDAO.updateCategoryInfo(ConverterUtll.convertDtoToDao(categoryDTO));
	}
	
	@Override
	public boolean deleteCategoryInfo(CategoryDTO categoryDTO) {
		return categoryDAO.deleteCategoryInfo(ConverterUtll.convertDtoToDao(categoryDTO));
	}
	
	@Override
	public List<CategoryDTO> getAllCategories(){
		List<CategoryDTO> categoryDTOs = new ArrayList<>();
		for(Category category : categoryDAO.getAllCategories() ){
			CategoryDTO categoryDTO = new CategoryDTO();
			categoryDTO.setCatId(category.getCatId());
			categoryDTO.setName(category.getName());
			categoryDTO.setDescription(category.getDescription());
			categoryDTO.setLastModified(category.getLastModified());
			categoryDTOs.add(categoryDTO);
		}
		return categoryDTOs;
	}
	
	@Override
	public CategoryDTO findCategoryById(UUID uuid){
		return ConverterUtll.convertDaoToDto(categoryDAO.findCategoryById(uuid));
	}
	

	//location
	@Override
	public boolean addLocationInfo(LocationDTO locationtDTO) {
		return locationDAO.addLocationInfo(ConverterUtll.convertDtoToDao(locationtDTO));
	}

	@Override
	public boolean updateLocationInfo(LocationDTO locationtDTO) {
		return locationDAO.updateLocationInfo(ConverterUtll.convertDtoToDao(locationtDTO));
	}
	
	@Override
	public boolean deleteLocationInfo(LocationDTO locationtDTO) {
		return locationDAO.deleteLocationInfo(ConverterUtll.convertDtoToDao(locationtDTO));
	}
	
	@Override
	public List<LocationDTO> getAllLocations(){
		List<LocationDTO> locationDTOs = new ArrayList<>();
		for(Location location : locationDAO.getAllLocations() ){
			LocationDTO locationDTO = new LocationDTO();
			locationDTO.setLocId(location.getLocId());
			locationDTO.setName(location.getName());
			locationDTO.setLatitude(location.getLatitude());
			locationDTO.setLongitude(location.getLongitude());
			locationDTO.setDescription(location.getDescription());
			locationDTO.setLastModified(location.getLastModified());
			locationDTOs.add(locationDTO);
		}
		return locationDTOs;
	}
	
	@Override
	public LocationDTO findLocationById(UUID uuid){
		return ConverterUtll.convertDaoToDto(locationDAO.findLocationById(uuid));
	}
	
	//Gateway
	@Override
	public boolean addGatewayInfo(GatewayDTO gatewayDto) {
		return gatewayDAO.addGatewayInfo(ConverterUtll.convertDtoToDao(gatewayDto));
	}

	@Override
	public boolean updateGatewayInfo(GatewayDTO gatewayDto) {
		return gatewayDAO.updateGatewayInfo(ConverterUtll.convertDtoToDao(gatewayDto));
	}
	
	@Override
	public boolean deleteGatewayInfo(GatewayDTO gatewayDto) {
		return gatewayDAO.deleteGatewayInfo(ConverterUtll.convertDtoToDao(gatewayDto));
	}
	
	@Override
	public List<GatewayDTO> getAllGateways(){
		List<GatewayDTO> gatewayDTOs = new ArrayList<>();
		for(Gateway gateway : gatewayDAO.getAllGateways()){
			 GatewayDTO  gatewayDTO = new GatewayDTO();
			 gatewayDTO.setgId(gateway.getgId());
			 gatewayDTO.setLocId(gateway.getLocId());
			 gatewayDTO.setName(gateway.getName());
			 gatewayDTO.setOrgId(gateway.getOrgId());
			 gatewayDTO.setMacId(gateway.getMacId());
			 gatewayDTO.setDescription(gateway.getDescription());
			 gatewayDTO.setStatus(gateway.isStatus());
			 gatewayDTO.setLastModified(gateway.getLastModified());
			 gatewayDTOs.add(gatewayDTO);
		}
		return gatewayDTOs;
	}
	
	@Override
	public GatewayDTO findGatewayById(UUID uuid){
		return ConverterUtll.convertDaoToDto(gatewayDAO.findByGatewayById(uuid));
	}
	
	//device
	@Override
	public boolean saveDeviceInfo(DeviceDTO deviceDTO) {
		return deviceDAO.saveDeviceInfo(ConverterUtll.convertDtoToDao(deviceDTO));
	}
	
	@Override
	public boolean updateDeviceInfo(DeviceDTO deviceDTO) {
		return deviceDAO.updateDeviceInfo(ConverterUtll.convertDtoToDao(deviceDTO));
	}
	
	@Override
	public boolean deleteDeviceInfo(DeviceDTO deviceDTO) {
		return deviceDAO.deleteDeviceInfo(ConverterUtll.convertDtoToDao(deviceDTO));
	}
	
	@Override
	public List<DeviceDTO> getAllDevices(){
		List<DeviceDTO> devicesDTOs = new ArrayList<>();
		for(Device device : deviceDAO.getAllDevices() ){
			DeviceDTO deviceDTO = new DeviceDTO();
			deviceDTO.setDevId(device.getDevId());
			deviceDTO.setName(device.getName());
			deviceDTO.setMacId(device.getMacId());
			deviceDTO.setCatId(device.getCatId());
			deviceDTO.setgId(device.getgId());
			deviceDTO.setAttributes(device.getAttributes());
			deviceDTO.setLastModified(device.getLastModified());
			deviceDTO.setStatus(device.isStatus());
			devicesDTOs.add(deviceDTO);
		}
		return devicesDTOs;
	}
	
	@Override
	public DeviceDTO findDeviceById(UUID uuid){
		return ConverterUtll.convertDaoToDto(deviceDAO.findDeviceById(uuid));
	}
	

	//organization
	@Override
	public boolean saveOrganizationInfo(OrganizationDTO organizationDTO) {
		return organizationDAO.saveOrganizationData(ConverterUtll.convertDtoToDao(organizationDTO));
	}

	@Override
	public boolean updateOrganizationInfo(OrganizationDTO organizationDTO) {
		return organizationDAO.updateOrganizationInfo(ConverterUtll.convertDtoToDao(organizationDTO));
	}
	
	@Override
	public boolean deleteOrganizationInfo(OrganizationDTO organizationDTO) {
		return organizationDAO.deleteOrganizationInfo(ConverterUtll.convertDtoToDao(organizationDTO));
	}
	
	@Override
	public List<OrganizationDTO> getAllOrganization(){
		List<OrganizationDTO> organizationDTOs = new ArrayList<>();
		for(Organization organization : organizationDAO.getAllOrganization() ){
			OrganizationDTO organizationDTO = new OrganizationDTO();
			organizationDTO.setOrgId(organization.getOrgId());
			organizationDTO.setName(organization.getName());
			organizationDTO.setDescription(organization.getDescription());
			organizationDTO.setStatus(organization.isStatus());
			organizationDTO.setLastModified(organization.getLastModified());
			organizationDTOs.add(organizationDTO);
		}
		return organizationDTOs;
	}
	
	@Override
	public OrganizationDTO findOrganizationById(UUID uuid){
		return ConverterUtll.convertDaoToDto(organizationDAO.findOrganizationById(uuid));
	}

}
