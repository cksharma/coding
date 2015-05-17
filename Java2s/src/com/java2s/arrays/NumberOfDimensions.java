package com.java2s.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class NumberOfDimensions {
	public static void main(String args[]) {
		String[][] data = new String[3][4];
		System.out.println(getDimension(data));
	}

	public static int getDimension(Object array) {
		int dim = 0;
		Class c = array.getClass();
		while (c.isArray()) {
			c = c.getComponentType();
			dim++;
		}
		
		return (dim);
		
	}
}
