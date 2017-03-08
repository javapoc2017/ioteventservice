package com.semisol.data.dao.api;

import java.util.List;
import java.util.UUID;

import org.springframework.context.annotation.Configuration;

import com.semisol.data.domain.Location;

@Configuration
public interface LocationDAO {

	boolean addLocationInfo(Location location);

	boolean updateLocationInfo(Location location);

	boolean deleteLocationInfo(Location location);

	List<Location> getAllLocations();

	Location findLocationById(UUID locationId);
}
