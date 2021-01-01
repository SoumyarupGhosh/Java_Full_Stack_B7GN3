package com.wellsfargo.batch7.group3.ibs.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

public class LoadPropertiesFile {
	
	public static Double getValue(String key, Long tenure) 
	{
		Double valueD = null;
		
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("src/main/resources/interestRate.properties"));
			String Value = key + tenure;
			System.out.println("interest key conact" + Value);
			
			
			String Value1= prop.getProperty(Value);	
			if(Value1!=null)
			{
			 valueD =Double.parseDouble(Value1);
			}
			System.out.println("interest key conact" + Value1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		
		return valueD;
		
		
	}
	
	public static Double getAmount(String key) 
	{
		Double valueD = null;
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("src/main/resources/interestRate.properties"));	
			String Value1= prop.getProperty(key);	
			 valueD =Double.parseDouble(Value1);	
			System.out.println("interest key conact" + Value1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return valueD;	
	}
	
	public static Long getValue(String key) 
	{
		Long valueD = null;
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("src/main/resources/interestRate.properties"));			
			
			String Value1= prop.getProperty(key);			
			 valueD =Long.parseLong(Value1);			
			System.out.println("interest key conact" + Value1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		
		return valueD;
		
		
	}
	
	public static String getBranch(String key) 
	{
		String valueD = null;
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("src/main/resources/bankBranchIFSC.properties"));		
			 valueD= prop.getProperty(key);			
			System.out.println("interest key conact" + valueD);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		
		return valueD;
		
	}
	
	public static List<String> getBranchList(String key) 
	{
		List<String> result = null;
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("src/main/resources/bankBranchIFSC.properties"));		
			String keyValue = prop.getProperty(key);
			
			  result = Arrays.stream(keyValue.split(",")).collect(Collectors.toList());
		} catch (IOException e) {
			
			e.printStackTrace();
		}		
		
		
		
		return result;
		
	}
	
	public static List<Long> getTenureList( String key) 
	{
	    List<Long> result = new ArrayList<Long>();
	    Properties prop = new Properties();
	    try {
			prop.load(new FileInputStream("src/main/resources/interestRate.properties"));	
			
			String keyValue = prop.getProperty(key);
			
			result = Arrays.asList(keyValue.split(",")).stream().map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
			
//			    for (Map.Entry<Object, Object> entry : prop.entrySet())
//			    {
//							//	        if (((String)entry.getKey()).matches("^" + Pattern.quote(name) + "\\.\\d+$"))
//							//	        {
//							//	            result.add((String) entry.getValue());
//							//	        }	
//			    	
//			    		Long longValue= Long.parseLong((String) entry.getValue());
//			    		result.add(longValue);
//			    }
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	    return result;
	}

}
