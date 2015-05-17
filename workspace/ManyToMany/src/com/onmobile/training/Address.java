package com.onmobile.training;

import java.util.Set;

public class Address {
	private int addressId;
	private String location;
	private String city;
	
	private Set <Customer> setCustomer;
		
	public Set<Customer> getSetCustomer() {
		return setCustomer;
	}
	public void setSetCustomer(Set<Customer> setCustomer) {
		this.setCustomer = setCustomer;
	}
	
	public int getAddressId() {
		return addressId;
	}
	
	public Address(int addressId, String location, String city) {
		super();
		this.addressId = addressId;
		this.location = location;
		this.city = city;
	}
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
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
}
