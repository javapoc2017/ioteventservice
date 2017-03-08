package com.semisol.data.dao.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.semisol.data.dao.api.LocationDAO;
import com.semisol.data.domain.Category;
import com.semisol.data.domain.Location;
import com.semisol.data.repository.LocationRepository;

@Configuration
public class LocationDAOImpl implements LocationDAO {

	@Autowired
	private LocationRepository locationRepository;

	@Override
	public boolean addLocationInfo(Location location) {	
		try {
			locationRepository.save(location);
		} catch (Exception ex) {
			return false;
		}
		return true;

	}

	@Override
	public boolean updateLocationInfo(Location location) {
		try {
			//categoryRepository.update(location);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteLocationInfo(Location location) {
		try {
			locationRepository.delete(location);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	@Override
	public List<Location> getAllLocations() {
		return (List<Location>) locationRepository.findAll();
	}

	@Override
	public Location findLocationById(UUID locId) {
		return locationRepository.findByLocId(locId);
	}

}
