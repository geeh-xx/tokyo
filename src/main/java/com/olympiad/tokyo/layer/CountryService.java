package com.olympiad.tokyo.layer;

import java.util.List;

import com.olympiad.tokyo.model.Country;


public interface CountryService {
	public Country getCountryById(long id);
	public Country saveCountry(Country country);
	public List<Country> getAll();
	public boolean existCountry(String name);
	public void deleteCountry(Country country);
	public void deleteCountryById(long id);
}
