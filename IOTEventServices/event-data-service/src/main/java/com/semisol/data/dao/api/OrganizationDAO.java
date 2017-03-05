package com.semisol.data.dao.api;

import org.springframework.context.annotation.Configuration;

import com.semisol.data.domain.Organization;

@Configuration
public interface OrganizationDAO {
	boolean saveOrganizationData(Organization organization);
}
