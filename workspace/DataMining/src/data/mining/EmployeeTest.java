package data.mining;

import java.util.Set;
import java.util.TreeSet;
public class EmployeeTest 
{
	public static void main(String[] args) 
	{
		Set <Employee> st = new TreeSet <Employee> (new ComparatorEmployee());
		st.add(new Employee(1, "Chandra", "Developer", 30000));
		st.add(new Employee(1, "Chandra1", "Developer", 30000));
		for(Employee e : st)
		{
			System.out.println(e);
		}
	}
}
