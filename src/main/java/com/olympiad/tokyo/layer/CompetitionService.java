package com.olympiad.tokyo.layer;

import java.util.List;

import com.olympiad.tokyo.dto.CompetitionDTO;
import com.olympiad.tokyo.exception.CompetitonException;
import com.olympiad.tokyo.model.Competition;

public interface CompetitionService {
	public Competition saveCompetition (CompetitionDTO competitionDTO) throws CompetitonException;
	public Competition save (Competition competition);
	public List<Competition> getAll();
	public Long findConflicts(Competition competition);
	public Long findConflictsDay(Competition competiton); 
	public List<Competition> findByModality(String modality); 
	public List<Competition> findAllByOrderByStartAsc();

}
