package com.olympiad.tokyo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.olympiad.tokyo.model.Modality;


@Repository("modalityRepository")
public interface ModalityRepository extends JpaRepository<Modality,Long>{
	boolean existsByNameIgnoreCase (String name);
	Modality findByNameIgnoreCase (String name);
}
