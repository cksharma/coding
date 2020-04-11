package com.onmobile.training;

import java.io.Serializable;

public class Person implements Serializable{
	private Name name;
	private int age;
	
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Person(Name name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}	
}
