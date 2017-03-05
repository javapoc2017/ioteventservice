package com.semisol.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semisol.data.dao.api.AdminDAO;
import com.semisol.iot.dto.CategoryDTO;
import com.semisol.iot.dto.DeviceDTO;
import com.semisol.iot.dto.GatewayDTO;
import com.semisol.iot.dto.LocationDTO;
import com.semisol.iot.dto.OrganizationDTO;
import com.semisol.iot.util.ConverterUtll;
import com.semisol.service.api.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO adminDAO;

	@Override
	public boolean saveDeviceInfo(DeviceDTO deviceDTO) {
		return adminDAO.saveDeviceInfo(ConverterUtll.convertDtoToDao(deviceDTO));
	}

	@Override
	public boolean saveOrganizationInfo(OrganizationDTO organizationDTO) {
		return adminDAO.saveOrganizationData(ConverterUtll.convertDtoToDao(organizationDTO));
	}

	@Override
	public boolean saveCategoryInfo(CategoryDTO categoryDTO) {
		return adminDAO.saveCategoryInfo(ConverterUtll.convertDtoToDao(categoryDTO));
	}

	@Override
	public boolean saveLocationInfo(LocationDTO locationDTO) {
		return adminDAO.saveLocationInfo(ConverterUtll.convertDtoToDao(locationDTO));
	}

	@Override
	public boolean saveGatewayInfo(GatewayDTO gatewayDTO) {
		return adminDAO.saveGatewayInfo(ConverterUtll.convertDtoToDao(gatewayDTO));
	}

}
