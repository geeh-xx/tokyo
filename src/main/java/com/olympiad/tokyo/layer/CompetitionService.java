package com.olympiad.tokyo.layer;

import java.util.List;

import com.olympiad.tokyo.dto.CompetitionDTO;
import com.olympiad.tokyo.model.Competition;

public interface CompetitionService {
	public Competition saveCompetition(CompetitionDTO competitionDTO);
	public List<Competition> getAll();
	public void deleteCompetition(Competition competition);
	public void deleteCompetitionById(long id);
}
