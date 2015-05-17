package com.onmobile.training.collections;

import java.util.HashSet;
import java.util.Set;

import com.onmobile.training.Employee;

public class SetTest2 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Set s = new HashSet();
		s.add(new Employee(1,"Rajesh","Developer",500000));
		s.add(new Employee(1,"Rajesh","Developer",500000));
		s.add(new Employee(1,"Rajesh","Developer",500000));
		s.add(new Number1(35,36));
		s.add(new Number1(35,36));

		System.out.println(s);
	}
}