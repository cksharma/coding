package com.onmobile.training;

import java.io.Serializable;
import java.util.Set;

public class Employee implements Serializable{

	private int empid;
	private String name;
	private String designation;
	private int manager;
	private Set<Project> projects;
	
	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
public Employee(int empid, String name, String designation, int manager) {
		super();
		this.empid = empid;
		this.name = name;
		this.designation = designation;
		this.manager = manager;
	}
	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getManager() {
		return manager;
	}
	public void setManager(int manager) {
		this.manager = manager;
	}
	
}