package de.gzockoll.common.types;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeFactory {
	private static SimpleDateFormat dateFormat = new SimpleDateFormat( "dd.MM.yyyy"); 
	private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat( "dd.MM.yyyy HH:mm"); 
	public static Date now() {
		return new Date();
	}

	public static Date parseDate(String string) {
		return parse(string,dateFormat);
	}

	public static Date parseDateTime(String string) {
		return parse(string,dateTimeFormat);
	}
	
	public static Date parse(String string,SimpleDateFormat format) {
		try {
			return format.parse(string);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

}
