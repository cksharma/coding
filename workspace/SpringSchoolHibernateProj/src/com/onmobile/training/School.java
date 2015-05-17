package com.onmobile.training;

import java.util.Set;

public class School {
	private String name;
	private Set<Student> students;
	//private Set<Teacher> teachers;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	/*public Set<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}*/
	public School(String name) {
		super();
		this.name = name;
	}
	public School() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
