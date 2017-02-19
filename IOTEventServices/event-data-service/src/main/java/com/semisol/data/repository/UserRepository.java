package com.semisol.data.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.semisol.data.domain.User;

@Repository
public interface UserRepository extends CassandraRepository<User>{
	@Query("select * from user where username= ?0 and password= ?1")
	User verifyUserCredentials(String username,String password);

}
