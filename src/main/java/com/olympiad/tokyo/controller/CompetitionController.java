package com.olympiad.tokyo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.olympiad.tokyo.dto.CompetitionDTO;
import com.olympiad.tokyo.layer.CompetitionService;
import com.olympiad.tokyo.model.Competition;


@RestController
@RequestMapping("/api")
public class CompetitionController {

	private static final Logger logger = LoggerFactory.getLogger(CountryController.class);

	@Autowired
	CompetitionService service;
	
	@RequestMapping(value="/v1/competition", method=RequestMethod.GET)
	public ResponseEntity<List<Competition>> getAllCompetition(){
    	logger.info("Returning all the Competitions");
		return new ResponseEntity<List<Competition>>(service.getAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/v1/competition", method = RequestMethod.POST)
   	public ResponseEntity<CompetitionDTO> save(@RequestBody CompetitionDTO payload){
    	logger.info("Payload to save " + payload);
		//return new ResponseEntity<Country>(service.saveCountry(payload), HttpStatus.OK);
		return new ResponseEntity<CompetitionDTO>(payload, HttpStatus.OK);
   	}
	
}
