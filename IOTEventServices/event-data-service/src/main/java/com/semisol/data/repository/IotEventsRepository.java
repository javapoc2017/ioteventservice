package com.semisol.data.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.semisol.data.domain.IotEvents;

public interface IotEventsRepository extends CassandraRepository<IotEvents>{

}
