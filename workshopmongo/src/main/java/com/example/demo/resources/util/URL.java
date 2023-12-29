/*------------------- packages -------------------*/
package com.example.demo.resources.util;

/*------------------- imports -------------------*/
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

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
}
