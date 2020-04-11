package com.java2s.reflection;

import java.lang.reflect.Constructor;

public class GetConstructor {

	public static void main(String[] args) {
		Constructor[] cs = String.class.getConstructors();
		for (int i = 0; i < cs.length; i++) {
			System.out.println(cs[i]);
		}
		System.out.println("====================");
		try {
			Constructor c = String.class.getConstructor(new Class[] { String.class });
			System.out.println(c);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
}
