package com.olympiad.tokyo.layer;

import java.util.List;

import com.olympiad.tokyo.model.Country;


public interface CountryService {
	public Country getCountryById(long id);
	public List<Country> getAll();
	public boolean existCountry(String name);
	public Country saveOrReturnContry(Country country);
	public Country findCountryByName(String name);
}
