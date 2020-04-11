package com.java2s.arrays;

import java.lang.reflect.Array;

public class MainClass {
	public static void main(String args[]) {
		int[] object = { 1, 2, 3 };
		Class type = object.getClass();
		if (type.isArray()) {
			Class elementType = type.getComponentType();
			System.out.println("Array of: " + elementType);
			System.out.println("Length: " + Array.getLength(object));
		}
	}
}
