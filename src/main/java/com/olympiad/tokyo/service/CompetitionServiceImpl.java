package com.olympiad.tokyo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olympiad.tokyo.dto.CompetitionDTO;
import com.olympiad.tokyo.layer.CompetitionService;
import com.olympiad.tokyo.model.Competition;
import com.olympiad.tokyo.repository.CompetitionRepository;

@Service("competitionService")
public class CompetitionServiceImpl implements CompetitionService{

	@Autowired
	CompetitionRepository competitionRepository;
	
	@Override
	public Competition saveCompetition(CompetitionDTO competitionDTO) {
		//return competitionRepository.save(competition);
		return null;
	}

	@Override
	public List<Competition> getAll() {
		return competitionRepository.findAll();
	}

	@Override
	public void deleteCompetition(Competition competition) {
		competitionRepository.delete(competition);
	}

	@Override
	public void deleteCompetitionById(long id) {
		competitionRepository.delete(id);
	}

}
