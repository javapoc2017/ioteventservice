package com.semisol.data.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.semisol.data.domain.IotEvents;

@Repository
public interface IotEventsRepository extends CassandraRepository<IotEvents> {
	@Query("select * from iot_events where devId= ?0 order by eventTime desc limit 1")
	IotEvents findLatestEventByDevice(String devId);
}
