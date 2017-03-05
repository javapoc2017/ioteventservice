package com.semisol.data.dao.api;

import org.springframework.context.annotation.Configuration;

import com.semisol.data.domain.Category;
import com.semisol.data.domain.Device;
import com.semisol.data.domain.Gateway;
import com.semisol.data.domain.Location;
import com.semisol.data.domain.Organization;


@Configuration
public interface AdminDAO {

	boolean saveCategoryInfo(Category category);

	boolean saveGatewayInfo(Gateway gateway);

	boolean saveLocationInfo(Location location);

	boolean saveDeviceInfo(Device device);

	boolean saveOrganizationData(Organization organization);
}
