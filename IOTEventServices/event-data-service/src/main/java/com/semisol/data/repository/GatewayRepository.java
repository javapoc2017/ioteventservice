package com.semisol.data.repository;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.semisol.data.domain.Gateway;

@Repository
public interface GatewayRepository extends CassandraRepository<Gateway>{
	Gateway findByGId(UUID gId);
	
}
