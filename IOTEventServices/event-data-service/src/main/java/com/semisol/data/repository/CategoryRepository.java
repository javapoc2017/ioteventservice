package com.semisol.data.repository;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.semisol.data.domain.Category;

@Repository
public interface CategoryRepository extends CassandraRepository<Category>{
	Category findByCatId(UUID catId);
}
