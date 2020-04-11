package com.onmobile.training;

public class EmployeeTest {

	
	public static void main(String[] args)
	{
		Employee e = new Employee(1,"Rajesh","Developer",5000);
		System.out.println("EmployeeId:" +e.getEmployeeId());
		System.out.println("Employee name:" +e.getEmployeeName());
		System.out.println("Designation:" +e.getDesignation());
		System.out.println("salary:" +e.getSalary());
	}

}
