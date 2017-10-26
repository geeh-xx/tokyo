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

import com.olympiad.tokyo.layer.CountryService;
import com.olympiad.tokyo.model.Country;

@RestController
@RequestMapping("/api")
public class CountryController {

	private static final Logger logger = LoggerFactory.getLogger(CountryController.class);

	@Autowired
	private CountryService service;
	
	

	@RequestMapping(value="/v1/country", method=RequestMethod.GET)
	public ResponseEntity<List<Country>> getAllCountry(){
    	logger.info("Returning all the Countrys");
		return new ResponseEntity<List<Country>>(service.getAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/v1/country", method = RequestMethod.POST)
   	public ResponseEntity<Country> save(@RequestBody Country payload){
    	logger.info("Payload to save " + payload);
		return new ResponseEntity<Country>(service.saveCountry(payload), HttpStatus.OK);
   	}
	
}
