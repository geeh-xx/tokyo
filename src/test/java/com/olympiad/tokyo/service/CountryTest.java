package com.olympiad.tokyo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.olympiad.tokyo.model.Country;
import com.olympiad.tokyo.repository.CountryRepository;
import com.olympiad.tokyo.service.CountryServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class CountryTest {
	
	@Mock
	private CountryRepository countryRepository;
	
	@InjectMocks
	private CountryServiceImpl countryServiceImpl;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void testSaveOrReturnContry(){
		Country country = new Country("Brazil");
		when(countryServiceImpl.saveOrReturnContry(country)).thenReturn(country);
		Country result = countryServiceImpl.saveOrReturnContry(country);
		assertEquals("Brazil", result.getName());
		
	}
	
	@Test
	public void testFindCountryByName(){
		Country country = new Country("France");
		when(countryServiceImpl.findCountryByName("France")).thenReturn(country);
		Country result = countryServiceImpl.findCountryByName(country.getName());
		assertEquals("France", result.getName());
		
	}
}
