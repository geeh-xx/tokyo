package com.olympiad.tokyo.util;

import org.springframework.util.StringUtils;

import com.olympiad.tokyo.dto.CompetitionDTO;

public class PayLoadValidation {

	public static boolean isValid (CompetitionDTO dto){
	
		if (StringUtils.isEmpty(dto.getFinish())) {
			return false;
		}
		if (StringUtils.isEmpty(dto.getLocal())) {
			return false;
		}
		if (StringUtils.isEmpty(dto.getModality())) {
			return false;
		}
		if (StringUtils.isEmpty(dto.getStage())) {
			return false;
		}
		if (StringUtils.isEmpty(dto.getStart())) {
			return false;
		}
		if (dto.getCountries() == null || dto.getCountries().size()> 2 || dto.getCountries().size()< 2) {
			return false;
		}
		
		return true;
	}
}
