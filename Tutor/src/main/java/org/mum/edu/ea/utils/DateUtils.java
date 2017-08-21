package org.mum.edu.ea.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
     
	public static Date convertStringToDate(String s){
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,
				Locale.US);
		Date date =null;
		try {
			date = df.parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return date;
	}
	
	public static String convertDateToString(Date d){
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,
				Locale.US);
		
		return  df.format(d);
	}
	
	public static Date returnCurrentDate(){
		Date d = new Date();
	    String s = convertDateToString(d);			
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,
				Locale.US);
		Date now =null;
		try {
			now = df.parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return now;  
	}
	
	
}
