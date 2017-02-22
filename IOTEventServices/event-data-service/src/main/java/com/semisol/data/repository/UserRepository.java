package com.semisol.data.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.semisol.data.domain.User;

@Repository
public interface UserRepository extends CassandraRepository<User>{
	@Query("select userid,username,first_name,last_name,email,mobileno,password,orgid,device from user where username = ?0 ")
	User verifyUserCredentials(String username);
	
	@Query("select count(1) from user where username = ?0")
	Integer verifyUserID(String username);

}
