package com.onmobile.training.collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.TreeMap;

import com.onmobile.training.Employee;

public class MapTest1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map <String, List <Employee>> m = new TreeMap <String, List <Employee>> ();
		
		List <Employee> onmobileList = new ArrayList <Employee> ();
		onmobileList.add(new Employee(1, "Rajesh", "Developer", 30000));
		onmobileList.add(new Employee(2, "Chandra", "Developer", 40000));
		
		List <Employee> wiproList = new ArrayList <Employee> ();
		wiproList.add(new Employee(3, "hero", "traineer", 23000));
		wiproList.add(new Employee(4, "rahul", "engineer", 300000));
		m.put("OnMobile", onmobileList);
		m.put("Wipro", wiproList);
		
		List <Employee> infyList = new ArrayList <Employee> ();
		infyList.add(new Employee(1, "Rajesh", "Developer", 30000));
		infyList.add(new Employee(2, "Chandra", "Developer", 40000));
		m.put("Infosys", infyList);
		
		
		for(String e : m.keySet())
		{
			System.out.println(e + " ======= " + m.get(e));
		}
		
		/*Scanner sc = new Scanner(System.in);
		System.out.println("Enter the company name");
		String company = sc.nextLine();
		List <Employee> list = m.get(company);
		System.out.println("Employees of " + company);
		for(Employee e : list)
		{
			System.out.println(e);
		}
		*/
	}
}
