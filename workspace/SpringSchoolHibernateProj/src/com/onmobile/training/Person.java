package com.onmobile.training;

public abstract class Person {
	private String name;
	private String gender;
//	private Address address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	/*public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}*/
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String name, String gender, Address address) {
		super();
		this.name = name;
		this.gender = gender;
		//this.address = address;
	}
	public Person(String name, String gender) {
		super();
		this.name = name;
		this.gender = gender;
	}
	
	
	
}
