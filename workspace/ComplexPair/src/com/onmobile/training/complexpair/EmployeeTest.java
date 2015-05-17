package com.onmobile.training.complexpair;

import java.util.HashSet;
import java.util.Set;

public class EmployeeTest
{
	public static void main(String[] args) 
	{
		Set <Employee> st = new HashSet <Employee> ();
		st.add(new Employee(1, "chandra", "developer", 23000));
		st.add(new Employee(1, "chandra", "developer", 23000));
		System.out.println(st.size());
		for(Employee e : st) System.out.println(e.hashCode());
	}
}
