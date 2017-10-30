package com.olympiad.tokyo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olympiad.tokyo.dto.CompetitionDTO;
import com.olympiad.tokyo.enumeration.Stage;
import com.olympiad.tokyo.exception.CompetitonException;
import com.olympiad.tokyo.layer.CompetitionService;
import com.olympiad.tokyo.layer.CountryService;
import com.olympiad.tokyo.layer.LocalService;
import com.olympiad.tokyo.layer.ModalityService;
import com.olympiad.tokyo.model.Competition;
import com.olympiad.tokyo.model.Country;
import com.olympiad.tokyo.repository.CompetitionRepository;
import com.olympiad.tokyo.util.Util;

@Service("competitionService")
public class CompetitionServiceImpl implements CompetitionService{

	@Autowired
	CompetitionRepository competitionRepository;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private LocalService localService;
	
	@Autowired
	private ModalityService modalityService;
	
	Competition competition;
	List<Country> countries;

	
	@Override
	public Competition saveCompetition(CompetitionDTO competitionDTO) throws CompetitonException{
		
		competition = new Competition();
		countries= new ArrayList<Country>();
		
		competition.setFinish(Util.convertDate(competitionDTO.getFinish()));
		
		competition.setStart(Util.convertDate(competitionDTO.getStart()));
		
		competition.setLocal(localService.saveOrReturnLocal(competitionDTO.getLocal()));
		
		competition.setModality(modalityService.saveOrReturnModaliy(competitionDTO.getModality()));
		
		competition.setStage(Stage.fromValue(competitionDTO.getStage()));
		
		competitionDTO.getCountries().forEach(c -> countries.add(countryService.saveOrReturnContry(c)));
		
		competition.setCountries(countries);
		
		if (findConflicts(competition) > 0){
            throw new CompetitonException("Conflict,exists competition at this time");
		} 
		
		if (differenceMinutes(competition) < 30) {
            throw new CompetitonException("minimum time: 30minutes");
		}
		
		if (findConflictsDay(competition) >= 4) {
            throw new CompetitonException("reached limits of competitions");
		}
		
		return save(competition);
	}

	@Override
	public List<Competition> getAll() {
		return competitionRepository.findAll();
	}

	@Override
	public Competition save(Competition competition){
		return competitionRepository.save(competition);
	}
	
	@Override
	public Long findConflicts(Competition competition){
		Long result = competitionRepository.findConflicts(
								competition.getLocal().getName(),competition.getStart(),
								competition.getFinish(),competition.getModality().getName()
								);
		return result;
	}
	
	public long differenceMinutes(Competition competition){
		long diferencaMinutos = (competition.getFinish().getTime() - competition.getStart().getTime()) / (1000*60);
		return  diferencaMinutos;
	}

	@Override
	public Long findConflictsDay(Competition competiton) {
		Long result =  competitionRepository.findConflictsDay(competiton.getLocal().getName(),
							Util.BeginofDay(competiton.getStart()), Util.EndOfDay(competiton.getFinish()));
		return result;
	}

	@Override
	public List<Competition> findByModality(String modality) {
		return competitionRepository.findByModality(modality);
	}

	@Override
	public List<Competition> findAllByOrderByStartAsc() {
		return competitionRepository.findAllByOrderByStartAsc();
	}


}
