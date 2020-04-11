package com.adobe.reflection;

public class StringTest {

	public static void main(String[] args) {
		try {
			String pc = String.class.newInstance();
			System.out.println(pc.length());
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		} 
	}
}
