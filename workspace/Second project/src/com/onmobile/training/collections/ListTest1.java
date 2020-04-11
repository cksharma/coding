package com.onmobile.training.collections;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.List;

import com.onmobile.training.Employee;

public class ListTest1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List list = new LinkedList();
		list.add("Rajesh");
		list.add(354);
		list.add(34.66);
		list.add(new int[]{34,35});
		list.add(new Employee(1,"Rajesh","Developer",6000));
		list.add(2,"Arvind");
		list.add(5,788);
		list.add(34.66);
		list.remove(0);
		Iterator it = list.iterator();
		
		while(it.hasNext())
		{
			Object o= it.next();
			if(o instanceof int[])
			{
				int[] p = (int[])o;
				System.out.println("this is an integer array");
				System.out.println("Elements of the array");
				for(int a:p)
				{
					System.out.println(a);
					
					
				}}
				else
				{System.out.println(o);}
			}
			
			
			
		
		for(Object o:list)
		{
			System.out.println(o);
		}
		for(int i = 0;i<list.size();i++)
		{System.out.println(list.get(i));}
	}

}
