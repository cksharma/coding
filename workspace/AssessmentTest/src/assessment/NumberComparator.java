package assessment;

import java.util.Comparator;

public class NumberComparator implements Comparator <Integer> 
{

	@Override
	public int compare(Integer o1, Integer o2) 
	{
		return o2.compareTo(o1);
	}
	
}
