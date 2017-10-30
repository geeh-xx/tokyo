package com.olympiad.tokyo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.olympiad.tokyo.dto.CompetitionDTO;
import com.olympiad.tokyo.exception.CompetitonException;
import com.olympiad.tokyo.layer.CompetitionService;
import com.olympiad.tokyo.model.Competition;
import com.olympiad.tokyo.util.PayLoadValidation;


@RestController
@RequestMapping("/api")
public class CompetitionController {

	private static final Logger logger = LoggerFactory.getLogger(CompetitionController.class);

	@Autowired
	CompetitionService service;
	
	@RequestMapping(value = "/v1/competition", method=RequestMethod.GET)
	public ResponseEntity<List<Competition>> getAll(){
    	logger.info("Returning all the Competitions");
    	
    	return new ResponseEntity<List<Competition>>(service.findAllByOrderByStartAsc(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/v1/competition/{modality}", method=RequestMethod.GET)
	public ResponseEntity<List<Competition>> getAllByModality(@PathVariable("modality") String modality) throws CompetitonException{
    	logger.info("Returning all the Competitions");
    	
    	if (StringUtils.isEmpty(modality)) {
            throw new CompetitonException("modalityis blank");
		}
    	return new ResponseEntity<List<Competition>>(service.findByModality(modality), HttpStatus.OK); 
	}
	
	@RequestMapping(value = "/v1/competition", method = RequestMethod.POST)
   	public ResponseEntity<Competition> save(@RequestBody CompetitionDTO payload) throws CompetitonException{
    	logger.info("Payload to save " + payload);
    	
    	if (!PayLoadValidation.isValid(payload)){
            throw new CompetitonException("Payload malformed, please check syntax");
    	}
		return new ResponseEntity<Competition>(service.saveCompetition(payload), HttpStatus.OK);
   	}
	
}
