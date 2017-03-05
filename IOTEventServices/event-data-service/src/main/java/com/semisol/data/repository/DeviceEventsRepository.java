package com.semisol.data.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.semisol.data.domain.DeviceEvent;

@Repository
public interface DeviceEventsRepository extends CassandraRepository<DeviceEvent> {
	@Query("select * from device_events where devId= ?0 order by eventTime desc limit 1")
	DeviceEvent findLatestEventByDevice(String devId);
}
