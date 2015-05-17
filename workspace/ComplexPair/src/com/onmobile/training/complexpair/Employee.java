package com.onmobile.training.complexpair;

public class Employee {
	
	int employeeId;
	String employeeName;
	String designation;
	double salary;

	public Employee(int employeeId, String employeeName, String designation, double salary) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.designation = designation;
		this.salary = salary;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public String getDesignation() {
		return designation;
	}

	public double getSalary() {
		return salary;
	}
	
}
