package data.mining;

import java.util.Comparator;

public class ComparatorEmployee implements Comparator <Employee> 
{

	@Override
	public int compare(Employee o1, Employee o2) 
	{
		return o2.compareTo(o1);
	}
}
