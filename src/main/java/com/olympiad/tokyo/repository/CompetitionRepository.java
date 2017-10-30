package com.olympiad.tokyo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.olympiad.tokyo.model.Competition;

@Repository("competitionRepository")
public interface CompetitionRepository extends JpaRepository<Competition,Long>{
	
	@Query("SELECT COUNT(c.id) FROM Competition c LEFT JOIN c.local LEFT JOIN c.modality WHERE c.local.name = :local AND (:start BETWEEN c.start AND c.finish OR :finish BETWEEN c.start AND c.finish )AND c.modality.name = :modality")
	public Long findConflicts(@Param("local") String local,@Param("start") Date start,@Param("finish") Date finish,@Param("modality") String modality); 
	
	@Query("SELECT COUNT(c.id) FROM Competition c LEFT JOIN c.local WHERE c.local.name = :local AND c.start BETWEEN :start AND :finish")
	public Long findConflictsDay(@Param("local") String local,@Param("start") Date start,@Param("finish") Date finish); 
	
	@Query("SELECT c FROM Competition c LEFT JOIN c.modality WHERE LOWER(c.modality.name) = LOWER(:modality) ORDER BY c.start ASC")
	public List<Competition> findByModality(@Param("modality") String modality); 
	
	public List<Competition> findAllByOrderByStartAsc();
}
