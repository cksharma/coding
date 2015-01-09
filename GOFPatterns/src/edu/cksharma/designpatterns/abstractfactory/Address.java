package edu.cksharma.designpatterns.abstractfactory;

public abstract class Address {
	
	private String location;
	private String city;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public abstract String getCountry();
	
	public String toString()
	{
		return location + "\t" + city + "\t" + getCountry();
	}
}
