package com.java2s.collecions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
	 public static void main(String args[]) {
		    List<Character> list = new ArrayList<Character>();

		    list.add('X');

		    System.out.println("Element added to list: " + list.get(0));

		    Collection<Character> immutableCol = Collections.unmodifiableCollection(list);

		    immutableCol.add('Y');
		  }
}
