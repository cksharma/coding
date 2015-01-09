package com.onmobile.training.serialization;

public class Person {
	private String gender;
	private String name;
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Person(String gender, String name) {
		super();
		this.gender = gender;
		this.name = name;
	}
	public Person() {
		super();
		System.out.println("constructor of person");
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Person [gender=" + gender + ", name=" + name + "]";
	}
	
	
}
