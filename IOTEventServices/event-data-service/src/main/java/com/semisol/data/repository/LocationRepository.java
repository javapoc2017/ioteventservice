package com.semisol.data.repository;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.semisol.data.domain.Location;

@Repository
public interface LocationRepository extends CassandraRepository<Location>{
	Location findByLocId(UUID locId);
}
