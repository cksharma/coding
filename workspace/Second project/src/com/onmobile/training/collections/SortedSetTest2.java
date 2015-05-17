package com.onmobile.training.collections;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import com.onmobile.training.Employee;

public class SortedSetTest2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		/*Set <Employee> s = new TreeSet <Employee> (new EmployeeComparator()); // now this parameter will direct compiler to do sorint based in ascending order of salary
		s.add(new Employee(101, "Rajesh", "Developer", 60000));
		s.add(new Employee(105, "Arvind", "Developer", 40000));
		s.add(new Employee(102, "Deva", "Developer", 10000));
		for(Employee emp : s) System.out.println(emp);
		*/
		SortedSet <Pair <Number>> s = new TreeSet <Pair <Number>> (new PairComparator());
		s.add(new Pair <Number> (12, 11));
		s.add(new Pair <Number> (2, 90));
		s.add(new Pair <Number> (1, 66));
		s.add(new Pair <Number> (4, 66));
		for(Pair p : s)
		{
			System.out.println(p.getFirst() + "   " + p.getSecond());			
		}
	
	}
}
