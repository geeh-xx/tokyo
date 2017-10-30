package com.olympiad.tokyo.util;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.olympiad.tokyo.dto.CompetitionDTO;
import com.olympiad.tokyo.enumeration.Stage;
import com.olympiad.tokyo.exception.CompetitonException;
import com.olympiad.tokyo.model.Country;

public class UtilTest {
	
	@Test
	public void testPayLoadValidation(){
		
		CompetitionDTO dto = new CompetitionDTO();
		dto.setCountries(Arrays.asList(new Country("Brazil"),new Country("Canada")));
		dto.setFinish("07/07/2017 07:00");
		dto.setStart("07/07/2017 05:55");
		dto.setLocal("Mineirao");
		dto.setModality("Nada carpado");
		dto.setStage(Stage.SEMIFINAL.name());
		
		Assert.assertTrue(PayLoadValidation.isValid(dto));
		
		CompetitionDTO dtoInvalid = new CompetitionDTO();
		dto.setCountries(Arrays.asList(new Country("Brazil"),new Country("Canada")));
		dto.setFinish("07/07/2017 07:00");
		dto.setStage(Stage.SEMIFINAL.name());
		
		Assert.assertFalse(PayLoadValidation.isValid(dtoInvalid));
	}
	
	@Test(expected = ParseException.class)
	public void testConvertDate() throws CompetitonException{
		String date = "07/07/2017 07:00";
		Assert.assertNotEquals(Date.class, Util.convertDate(date));
	}
	
}
