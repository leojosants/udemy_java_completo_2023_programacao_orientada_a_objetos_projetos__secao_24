/*------------------- packages -------------------*/
package com.example.demo.resources.util;

/*------------------- imports -------------------*/
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/*------------------- class URL -------------------*/
public class URL {
	
	/*------------------- methods -------------------*/
	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} 
		catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	public static Date convertDate(String text_date, Date default_value) {
		SimpleDateFormat simple_date_format = instanceateSimpleDateFormat();
		simple_date_format.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		try {
			return simple_date_format.parse(text_date);
		} 
		catch (ParseException e) {
			return default_value;
		}
	}

	private static SimpleDateFormat instanceateSimpleDateFormat() {
		return new SimpleDateFormat("yyyy-MM-dd");
	}
}
