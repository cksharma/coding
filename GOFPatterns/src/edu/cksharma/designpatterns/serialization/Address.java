package edu.cksharma.designpatterns.serialization;

public class Address {
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
	public Address(String location, String city) {
		super();
		this.location = location;
		this.city = city;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Address [location=" + location + ", city=" + city + "]";
	}		
}
