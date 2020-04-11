package com.onmobile.training.collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GenericTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List <String> list = new LinkedList <String>();
		list.add("arun");
		list.add("arvind");
		list.add("sachin");
		Iterator <String> it = list.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		for(String item : list) System.out.println(item);
	}
}
