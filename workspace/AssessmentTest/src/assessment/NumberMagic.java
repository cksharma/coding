package assessment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class NumberMagic 
{
	public static boolean isPrime(int n) 
	{
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0)
				return false;
		}
		return n > 1;
	}
	
	public static void main(String[] args) 
	{
		List <Integer> lst = new ArrayList <Integer> ();
		Scanner si = new Scanner(System.in);
		System.out.println("Enter the numbers and to stop enter negative number");
		while(true)
		{
			int a = si.nextInt();
			if(a < 0) break;
			lst.add(a);
		}
		Map <Integer, Integer> tmap = new TreeMap <Integer, Integer> (new NumberComparator());
		for(int i = 0; i < lst.size(); i++)
		{
			if(tmap.containsKey(lst.get(i)))
			{
				tmap.put(lst.get(i), tmap.get(lst.get(i)) + 1);
			}
			else 
			{
				tmap.put(lst.get(i), 1);
			}
		}
		System.out.println("Values in Map are ");
		System.out.println();
		for(int item : tmap.keySet()) System.out.println(item + "    "+ tmap.get(item));
		System.out.println();
		Set <Integer> set1 = new TreeSet <Integer> ();
		Set <Integer> set2 = new TreeSet <Integer> ();
		
		for(int i = 0; i < lst.size(); i++)
		{
			if(isPrime(lst.get(i))) set1.add(lst.get(i));
			else set2.add(lst.get(i));
		}
		
		System.out.println("Non prime numbers are");
		for(int item : set2) System.out.print(item + "   ");
		System.out.println();
				
		System.out.println("Prime Numbers are");
		for(int item : set1) System.out.print(item + "   ");
		System.out.println();
		
	}
}
