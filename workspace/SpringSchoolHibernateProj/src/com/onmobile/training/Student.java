package com.onmobile.training;

public class Student extends Person{
	private int rollno;

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public Student(int rollno) {
		super();
		this.rollno = rollno;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name, String gender, int rollno) {
		super(name, gender);
		this.rollno = rollno;
	}
	
	
	

	
}
