package com.semisol.data.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.semisol.data.domain.User;

public interface UserRepository extends CassandraRepository<User>{

}
