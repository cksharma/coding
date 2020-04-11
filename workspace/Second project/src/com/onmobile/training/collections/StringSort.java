package com.onmobile.training.collections;

import java.util.Set;
import java.util.TreeSet;

public class StringSort {

	public static void main(String[] args) {
		Set <String> s = new TreeSet <String>(new StringComparator());
		s.add("aaaa");
		s.add("zzzz");
		s.add("bbbb");
		System.out.println(s);
	}
}
