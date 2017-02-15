package com.semisol.data.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.semisol.data.domain.Device;

public interface DeviceRepository extends CassandraRepository<Device>{

	

	
}
