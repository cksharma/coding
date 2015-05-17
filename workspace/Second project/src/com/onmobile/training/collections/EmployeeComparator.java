package com.onmobile.training.collections;

import java.util.Comparator;
import com.onmobile.training.Employee;

public class EmployeeComparator implements Comparator <Employee>
{
		@Override
		public int compare(Employee o1, Employee o2)
		{
			int comp = 0;
			if(o1.getSalary() < o2.getSalary())
			{
				comp = -1;				
			}
			else if(o1.getSalary() > o2.getSalary())
			{
				comp = 1;
			}
			return comp;			
		}
}
