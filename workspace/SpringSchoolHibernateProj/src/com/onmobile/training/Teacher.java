package com.onmobile.training;

public class Teacher extends Person{
	private String Subject;

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}
	
	public Teacher(String subject) {
		super();
		Subject = subject;
	}

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
}
