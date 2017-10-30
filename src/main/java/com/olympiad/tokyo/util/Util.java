package com.olympiad.tokyo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.util.StringUtils;

public class Util {

	
	public static Date convertDate(String date){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date dateFormated = null;
		
		if (!StringUtils.isEmpty(date)) {
			try {
				dateFormated = sdf.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return dateFormated;
	}
	
	public static Date BeginofDay(Date start){
		
		Calendar begin = Calendar.getInstance();
		
		begin.setTime(start);
		begin.set(Calendar.HOUR_OF_DAY, 0);
		begin.set(Calendar.MINUTE, 0);
		begin.set(Calendar.SECOND, 0);

		return new Date(begin.getTimeInMillis());
	}
	
	public static Date EndOfDay(Date finish){
		
		Calendar end = Calendar.getInstance();
		
		end.setTime(finish);
		end.set(Calendar.HOUR_OF_DAY, 23);
		end.set(Calendar.MINUTE, 59);
		end.set(Calendar.SECOND, 59);

		return new Date(end.getTimeInMillis());
	}
}
