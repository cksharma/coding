package com.java2s.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Deny {

	private Deny() {
		System.out.println("Deny constructor");
	}
}

public class ConstructorTroubleAccess {
	public static void main(String... args) {
		try {
			Constructor c = Deny.class.getDeclaredConstructor();
			c.setAccessible(true); // solution
			c.newInstance();
			System.out.println("Access private constructor");
			
		} catch (InvocationTargetException x) {
			x.printStackTrace();
		} catch (NoSuchMethodException x) {
			x.printStackTrace();
		} catch (InstantiationException x) {
			x.printStackTrace();
		} catch (IllegalAccessException x) {
			x.printStackTrace();
		}
	}
}
