package com.semisol.data.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.semisol.data.dao.api.AdminDAO;
import com.semisol.data.domain.Category;
import com.semisol.data.domain.Device;
import com.semisol.data.domain.Gateway;
import com.semisol.data.domain.Location;
import com.semisol.data.domain.Organization;
import com.semisol.data.repository.CategoryRepository;
import com.semisol.data.repository.DeviceRepository;
import com.semisol.data.repository.GatewayRepository;
import com.semisol.data.repository.LocationRepository;
import com.semisol.data.repository.OrganizationRepository;

@Configuration
public class AdminDAOImpl implements AdminDAO {

	@Autowired
	private DeviceRepository deviceRepository;
	
	@Autowired
	private OrganizationRepository organizationRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private GatewayRepository gatewayRepository;
	
	@Autowired
	private LocationRepository locationRepository;
	
	@Override
	public boolean saveCategoryInfo(Category category) {
		try {
			categoryRepository.save(category);
		} catch (Exception ex) {
			return false;
		}
		return true;

	}

	@Override
	public boolean saveGatewayInfo(Gateway gateway) {
		try {
			System.out.println(gateway);
			gatewayRepository.save(gateway);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	@Override
	public boolean saveLocationInfo(Location location) {
		try {
			locationRepository.save(location);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	@Override
	public boolean saveDeviceInfo(Device device) {
		try {
			deviceRepository.save(device);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	@Override
	public boolean saveOrganizationData(Organization organization) {
		try{
			organizationRepository.save(organization);
		}catch(Exception ex){
			return false;
		}
		return true;
	}

}
