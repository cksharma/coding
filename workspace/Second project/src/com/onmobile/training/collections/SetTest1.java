package com.onmobile.training.collections;

import java.util.HashSet;
import java.util.Set;

public class SetTest1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set s = new HashSet();
		s.add(34444);	
		s.add(34.53);
		s.add("hello");
		s.add(34444);/*no duplication*/
		System.out.println(s);/*toString method of hash set prints all the elements*/
		for(Object o:s)
		{
			System.out.println(o);
		}
	}

}
