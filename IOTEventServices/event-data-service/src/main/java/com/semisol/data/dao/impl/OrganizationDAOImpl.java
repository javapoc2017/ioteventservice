package com.semisol.data.dao.impl;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.semisol.data.dao.api.OrganizationDAO;
import com.semisol.data.domain.Organization;
import com.semisol.data.repository.OrganizationRepository;

@Configuration
public class OrganizationDAOImpl implements OrganizationDAO{
	
	@Autowired
	private OrganizationRepository organizationRepository;

	public void saveOrganizationData() {
		System.out.println("saving the data.. repo");
		Organization organization = new Organization();
		organization.setOrgid(UUID.randomUUID());
		organization.setDescription("Home");
		organization.setOrgname("Nisum2");
		Calendar cal=Calendar.getInstance();
		organization.setUpdated_time(new Timestamp(cal.getTimeInMillis()));
		organizationRepository.save(organization);
		System.out.println("saving the data.. repo ..done");
	}

}
