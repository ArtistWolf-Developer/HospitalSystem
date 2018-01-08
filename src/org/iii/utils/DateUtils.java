package org.iii.utils;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.text.DateFormatter;


public class DateUtils {

	private static String[] parsePatterns = {
		"yyyy-MM-dd",
		"yyyy-MM-dd HH:mm",
		"HH:mm",
		"H:mm",
		"yyyy/MM/dd",
		"yyyy/MM/dd HH:mm" };


	public static LocalDate convertLocalDate(String localDate) {
		Date date = new Date();
		for (String pattern : parsePatterns) {
		    try {
		    	SimpleDateFormat df = new SimpleDateFormat(pattern);
		    	date = df.parse(localDate);
		    	break;
		    } catch (Exception pe) {
		       //TODO
		    }
		}
		Instant instant = date.toInstant();
		ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
		return zdt.toLocalDate();
	}

	public static LocalTime convertLocalTime(String localTime) {
		Date date = new Date();
		for (String pattern : parsePatterns) {
		    try {
		    	SimpleDateFormat df = new SimpleDateFormat(pattern);
		    	date = df.parse(localTime);
		    	break;
		    } catch (Exception pe) {
		       //TODO
		    }
		}
		Instant instant = date.toInstant();
		ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
		return zdt.toLocalTime();
	}
}