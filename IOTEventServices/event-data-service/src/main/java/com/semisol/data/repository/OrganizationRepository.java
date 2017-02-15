package com.semisol.data.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.semisol.data.domain.Organization;

public interface OrganizationRepository extends CassandraRepository<Organization> {

}
