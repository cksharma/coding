package com.onmobile.training.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

interface I<T>
{
	T getObject();
}

class X implements I <String>
{
	@Override
	public String getObject() {
		// TODO Auto-generated method stub
		return "X";
	}
}

class Y implements I <String>
{

	@Override
	public String getObject() {
		// TODO Auto-generated method stub
		return "Y";
	}
}

public class GenericWildCardTest2 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		List <Set <I <String>>> list = new ArrayList <Set <I <String>>>(); // class implementing string is the implemented by set which is in turn implemented by list
		Set <I <String> > set1 = new HashSet <I <String>> ();
		Set <I <String> > set2 = new HashSet <I <String>> ();
		set1.add(new X());
		set1.add(new Y());
		set2.add(new X());
		set2.add(new Y());
		list.add(set1);
		list.add(set2);
		for(Set <I <String> > set : list)
		{
			System.out.println("printing the set");
			for(I <String> i : set)
			{
				System.out.println(i.getObject());
			}
		}
		/*List <Set <String> > list = new ArrayList <Set <String>> ();
		Set <String> set1= new HashSet <String> ();
		set1.add("xxxx");
		set1.add("yyyy");
		Set <String> set2 = new HashSet <String> ();
		set2.add("aaaa");
		set2.add("bbbb");
		list.add(set1);
		list.add(set2);
		for(Set <String> set : list)
		{
			System.out.println("printing the set in list");
			for(String s : set)
			{
				System.out.println(s);
			}
		}*/
	}
}
