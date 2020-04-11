package com.onmobile.training.collections;

import java.util.Comparator;

public class StringComparator implements Comparator <String>{

	@Override
	// m implementing it as sorting in descending order.
	public int compare(String s1, String s2) {
		// TODO Auto-generated method stub
		return s2.compareTo(s1);
	}
	
}
