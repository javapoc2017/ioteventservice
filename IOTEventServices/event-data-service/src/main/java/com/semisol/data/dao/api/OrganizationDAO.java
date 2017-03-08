package com.semisol.data.dao.api;

import java.util.List;
import java.util.UUID;

import org.springframework.context.annotation.Configuration;

import com.semisol.data.domain.Organization;

@Configuration
public interface OrganizationDAO {
	
	boolean saveOrganizationData(Organization organization);

	boolean updateOrganizationInfo(Organization organization);

	boolean deleteOrganizationInfo(Organization organization);

	List<Organization> getAllOrganization();

	Organization findOrganizationById(UUID orgId);
}
