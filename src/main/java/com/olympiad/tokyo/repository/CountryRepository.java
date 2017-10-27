package com.olympiad.tokyo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.olympiad.tokyo.model.Country;

@Repository("countryRepository")
public interface CountryRepository extends JpaRepository<Country,Long> {
	boolean existsByNameIgnoreCase (String name);
}
