package com.olympiad.tokyo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olympiad.tokyo.layer.CountryService;
import com.olympiad.tokyo.model.Country;
import com.olympiad.tokyo.repository.CountryRepository;

@Service("countryService")
public class CountryServiceImpl implements CountryService {


	@Autowired
	private CountryRepository countryRepository;

	@Override
	public Country getCountryById(long id) {
		return countryRepository.findOne(id);
	}

	@Override
	public Country saveCountry(Country country) {
		if (!existCountry(country.getName())) {
			return countryRepository.save(country);
		}
		return null;
	}

	@Override
	public boolean existCountry(String name) {
		return countryRepository.existsByNameIgnoreCase(name);
	}

	@Override
	public void deleteCountry(Country country) {
		countryRepository.delete(country);
	}

	@Override
	public void deleteCountryById(long id) {
		countryRepository.delete(id);
	}

	@Override
	public List<Country> getAll() {
		return countryRepository.findAll();
	}
	
	

}
