package com.wellsfargo.batch7.group3.ibs.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

import org.springframework.format.datetime.DateFormatter;

public class Converters {
	
	
	public static LocalDate stringToLocalDate(String oldDate)
	{
		LocalDate datetime=null;

	DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	try {
	     datetime = LocalDate.parse(oldDate, pattern);
	    System.out.println(datetime); 
	} catch (DateTimeParseException e) {
	   
	}
	return datetime;
	
	}
	
	public static Date stringToDate(String oldDate) throws ParseException
	{
		Date datetime=null;

	DateFormat pattern = new SimpleDateFormat("yyyy-MM-dd");

	try {
	     datetime = pattern.parse(oldDate);
	    System.out.println(datetime); 
	} catch (DateTimeParseException e) {
	   
	}
	return datetime;
	
	}
	
	public static Double getMaturityAmountFixed(Double amount, Double rate, Long tenure)
	{
		Double Interest= (amount*rate*(tenure/12))/100;
		
		System.out.println("Fixed Account matutirty date"+ (amount+Interest));
		return (amount+Interest);
	}
	
	public static Double getMaturityAmountRecurring(Double amount, Double rate, Long tenure)
	{
		Double r= 1+rate/400;
		Double m=(Double)Math.pow(r, tenure)-1;
		Double m1=m*amount;
		Double m2=1/(Double)Math.pow(r, .33);
		Double m3=1-m2;
		Double m4=m1/m3;
		
		return m4;
		
		
	}
}
