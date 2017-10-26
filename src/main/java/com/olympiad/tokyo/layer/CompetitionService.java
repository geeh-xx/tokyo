package com.olympiad.tokyo.layer;

import java.util.List;

import com.olympiad.tokyo.model.Competition;

public interface CompetitionService {
	public Competition saveCompetition(Competition competition);
	public List<Competition> getAll();
	public void deleteCompetition(Competition competition);
	public void deleteCompetitionById(long id);
}
