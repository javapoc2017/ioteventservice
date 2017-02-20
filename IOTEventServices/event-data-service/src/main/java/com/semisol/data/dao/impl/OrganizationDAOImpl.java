package com.semisol.data.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.semisol.data.dao.api.OrganizationDAO;
import com.semisol.data.domain.Organization;
import com.semisol.data.repository.OrganizationRepository;

@Configuration
public class OrganizationDAOImpl implements OrganizationDAO{
	
	@Autowired
	private OrganizationRepository organizationRepository;

	public boolean saveOrganizationData(Organization organization) {
		try{
			organizationRepository.save(organization);
		}catch(Exception ex){
			return false;
		}
		return true;
		
	}

}
