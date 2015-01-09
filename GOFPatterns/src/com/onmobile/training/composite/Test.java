package com.onmobile.training.composite;

public class Test {
	public static void main(String[] args) { 
		//Jpanel , DOMParserFactory all based on composite pattern.
		Employee e1 = new Employee(5000);
		Employee e2 = new Employee(6000);
		Employee e3 = new Employee(8000);
		Employee e4 = new Employee(5000);
		
		Employee e5 = new Employee(7000);
		Employee e6 = new Employee(6000);
		Employee e7 = new Employee(8000);
		Employee e8 = new Employee(5000);
		
		
		Manager gm1 = new Manager(10000, new Employee[]{e1, e2});
		Manager gm2 = new Manager(15000, new Employee[]{e3, e4});
		Manager gm3 = new Manager(20000, new Employee[]{e5, e6});
		Manager gm4 = new Manager(15000, new Employee[]{e7, e8});
		
		Manager vp1 = new Manager(30000, new Employee[]{gm1, gm2});
		Manager vp2 = new Manager(30000, new Employee[]{gm3, gm4});
		
		Manager ceo = new Manager(60000, new Employee[]{vp1, vp2});
		
		System.out.println("Total Pay : " + ceo.getDeptPay());
	}
}
