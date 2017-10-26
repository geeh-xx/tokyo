package com.olympiad.tokyo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.olympiad.tokyo.model.Competition;

@Repository("competitionRepository")
public interface CompetitionRepository extends JpaRepository<Competition,Long>{

}
