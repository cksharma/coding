package com.onmobile.training.collections;

import java.util.ArrayList;
import java.util.List;

class A
{
	@Override
	public String toString() {
		return "A";
	}
}

class B extends A
{
	@Override
	public String toString() {
		return "B";
	}
}

class C extends B
{
	@Override
	public String toString() {
		return "C";
	}
}

// in this program we are basically limiting the wild card variable's type

public class GenericWildCardTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*List <Integer> listInteger = new ArrayList <Integer> ();
		listInteger.add(22);
		listInteger.add(23);
		listInteger.add(12);
		listInteger.add(29);
		printList(listInteger);
		*/
		List <A> list = new ArrayList <A>();
		list.add(new A());
		list.add(new A());
		list.add(new A());
		printList(list);
		
		List <B> listB = new ArrayList <B> ();
		listB.add(new B());
		listB.add(new C());
		printList(listB);
		
		List <C> listC = new ArrayList <C>();
		listC.add(new C());
		listC.add(new C());
		printList(listC);
		
		// now for super class passing
		List <Object> listsuper = new ArrayList <Object> ();
		listsuper.add(new C());
		listsuper.add(new B());
		listsuper.add(new A());
		listsuper.add(new Object());
		printSuper(listsuper);
	}
	/*static void printList(List <? extends Number> list) // using the extends Number we limiting it to be either Number or subclass of Number
	{
		System.out.println(list);
	}
	*/
	static void printList (List <? extends A> list)
	{
		for(Object o : list)
		{
			System.out.println(o);
		}
	}
	static void printSuper (List < ? super C> list)
	{
		for(Object o : list)
		{
			System.out.println(o);
		}
	}
}
