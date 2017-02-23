package com.semisol.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semisol.data.dao.api.DeviceDAO;
import com.semisol.data.dao.api.OrganizationDAO;
import com.semisol.iot.dto.DeviceDTO;
import com.semisol.iot.dto.OrganizationDTO;
import com.semisol.iot.util.ConverterUtll;
import com.semisol.service.api.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	DeviceDAO deviceDAO;

	@Autowired
	OrganizationDAO organizationDAO;

	@Override
	public boolean saveDeviceInfo(DeviceDTO deviceDTO) {
		return deviceDAO.saveDeviceInfo(ConverterUtll.convertDtoToDao(deviceDTO));
	}

	@Override
	public boolean updateUserDevice() {
		return false;
	}

	@Override
	public boolean saveOrganizationInfo(OrganizationDTO organizationDTO) {
		return organizationDAO.saveOrganizationData(ConverterUtll.convertDtoToDao(organizationDTO));
	}

}
