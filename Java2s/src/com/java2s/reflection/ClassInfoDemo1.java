package com.java2s.reflection;

class ClassInfoDemo1 {
	public static void main(String[] args) {
		String s = "";

		Class c = s.getClass();
		System.out.println(c.getName());

		c = new ClassInfoDemo1().getClass();
		System.out.println(c.getName());
		
		
	}
}
