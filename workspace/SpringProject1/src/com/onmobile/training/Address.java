package com.onmobile.training;

public class Address {
	
	private String city;
	private String location;
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Address(String city, String location) {
		super();
		this.city = city;
		this.location = location;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

