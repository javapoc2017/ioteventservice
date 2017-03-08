package com.semisol.data.dao.impl;

import java.util.List;
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

	public boolean saveOrganizationData(Organization organization) {
		try{
			organizationRepository.save(organization);
		}catch(Exception ex){
			return false;
		}
		return true;
	}

	@Override
	public boolean updateOrganizationInfo(Organization organization) {
		try {
			//organizationRepository.update(organization);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	/*
	TODO : need to check before delete
	*/
	@Override
	public boolean deleteOrganizationInfo(Organization organization) {
		try {
			organizationRepository.delete(organization);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	@Override
	public List<Organization> getAllOrganization() {
		return (List<Organization>) organizationRepository.findAll();
	}

	@Override
	public Organization findOrganizationById(UUID orgId) {
		return organizationRepository.findByOrgId(orgId);
	}
}
