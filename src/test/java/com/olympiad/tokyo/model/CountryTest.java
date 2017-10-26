package com.olympiad.tokyo.model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
	public void saveCountry(){
		Country country = new Country("Brazil");
		when(countryRepository.save(country)).thenReturn(country);
		Country result = countryRepository.save(country);
		assertEquals("Brazil", result.getName());
		
		Country country3 = new Country("teste");

		when(countryServiceImpl.existCountry(matches("Brazil"))).thenReturn(true);
		when(countryServiceImpl.saveCountry(country3)).thenReturn(null);

		Country country5 = new Country("teste");

		
		assertNull(countryServiceImpl.saveCountry(country5));
	}
}
