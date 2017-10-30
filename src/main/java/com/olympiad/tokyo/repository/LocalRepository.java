package com.olympiad.tokyo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.olympiad.tokyo.model.Local;

@Repository("localRepository")
public interface LocalRepository extends JpaRepository<Local,Long>{
	boolean existsByNameIgnoreCase (String name);
	Local findByNameIgnoreCase (String name);
}
