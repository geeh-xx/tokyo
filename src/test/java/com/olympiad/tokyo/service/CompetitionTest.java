package com.olympiad.tokyo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.olympiad.tokyo.dto.CompetitionDTO;
import com.olympiad.tokyo.enumeration.Stage;
import com.olympiad.tokyo.exception.CompetitonException;
import com.olympiad.tokyo.model.Competition;
import com.olympiad.tokyo.model.Country;
import com.olympiad.tokyo.model.Local;
import com.olympiad.tokyo.model.Modality;
import com.olympiad.tokyo.repository.CompetitionRepository;


@RunWith(SpringJUnit4ClassRunner.class)
public class CompetitionTest {

	@Mock
	private CompetitionRepository competitionRepository;
	
	@InjectMocks
	private CompetitionServiceImpl competitionServiceImpl;
	
	private CompetitionDTO  dto; 
	
	private Competition competition;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		
		dto = new CompetitionDTO();
		dto.setCountries(Arrays.asList(new Country("Brazil"),new Country("Canada")));
		dto.setFinish("07/07/2017 07:00");
		dto.setStart("07/07/2017 05:55");
		dto.setLocal("Mineirao");
		dto.setModality("Nada carpado");
		dto.setStage(Stage.SEMIFINAL.name());
		
		competition = new Competition();
		competition.setCountries(Arrays.asList(new Country("Brazil"),new Country("Canada")));
		competition.setFinish(new Date("07/07/2017 07:00"));
		competition.setLocal(new Local("Mineirao"));
		competition.setModality(new Modality("Nada carpado"));
		competition.setStage(Stage.SEMIFINAL);
		competition.setStart(new Date("07/07/2017 05:55"));
		competition.setId(5L);
	}
	
	@Test
	public void testSaveCompetition() throws CompetitonException{
		when(competitionServiceImpl.save(competition)).thenReturn(competition);
		Competition result = competitionServiceImpl.save(competition);
		assertEquals("Mineirao", result.getLocal().getName());
		assertEquals(Long.valueOf(5), result.getId());
	}
	
}	
