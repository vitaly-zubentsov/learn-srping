package com.zubentsov.springdemo.mvc;

import java.util.LinkedHashMap;
import java.util.Map;

public class Student {

	private String name;
	
    private String lastName;
    
    private String Country;
    
    private Map<String,String> countryOptions;
    
    public Student() {
    	countryOptions = new LinkedHashMap<String, String>();
    	
    	countryOptions.put("Ru", "Russia");
    	countryOptions.put("EN", "England");
    	countryOptions.put("US", "USA");
    	countryOptions.put("IN", "India");
    	countryOptions.put("BZ", "Brazil");
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public Map<String, String> getCountryOptions() {
		return countryOptions;
	}
	
	
	
}
