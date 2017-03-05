package com.semisol.data.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.semisol.data.domain.Gateway;

@Repository
public interface GatewayRepository extends CassandraRepository<Gateway>{
	
}
