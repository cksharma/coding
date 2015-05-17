package com.onmobile.training.collections;

import com.onmobile.training.Employee;

public class PairTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pair <Integer> pairInt = new Pair <Integer> (12, 35);
		Pair <Double> pairDouble = new Pair <Double>(45.222, 778.33);
		//Pair <String> pairString = new Pair <String>("hello", "world");
		//Pair <Employee> pairEmp = new Pair <Employee> (new Employee(1, "Rajiv", "Developer", 50000), new Employee(2, "Arvind", "Develper", 45000));
		System.out.println(pairInt);
		System.out.println(pairDouble);
		//System.out.println(pairString);
		//System.out.println(pairEmp);
	}

}
