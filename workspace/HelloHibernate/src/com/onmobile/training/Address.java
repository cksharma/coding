package com.onmobile.training;

public class Address {
	
	private int addressId;
	private String location;
	private String city;
	private int empId;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getAddressId() {
		return addressId;
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
}
