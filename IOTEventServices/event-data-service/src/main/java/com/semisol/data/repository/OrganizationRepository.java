package com.semisol.data.repository;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.semisol.data.domain.Organization;

@Repository
public interface OrganizationRepository extends CassandraRepository<Organization> {
	Organization findByOrgId(UUID orgId);
}
