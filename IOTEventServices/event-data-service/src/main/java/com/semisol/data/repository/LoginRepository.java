package com.semisol.data.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.semisol.data.domain.Login;


public interface LoginRepository extends CassandraRepository<Login> {

}
