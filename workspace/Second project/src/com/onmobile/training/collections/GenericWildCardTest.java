package com.onmobile.training.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GenericWildCardTest 
{
	public static void main(String[] args) 
	{		
		List <String> listString = new LinkedList <String> ();
		listString.add("rajesh");
		listString.add("arjun");
		listString.add("bharath");
		printList(listString);
		List <Integer> listInteger = new ArrayList <Integer> ();
		listInteger.add(34);
		listInteger.add(31);
		listInteger.add(20);
		printList(listInteger);
		
	}
	static void printList (List <?> list)
	{
		for(Object o : list)
		{
			System.out.println(o);
		}
	}
}
