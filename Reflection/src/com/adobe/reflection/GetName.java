package com.adobe.reflection;

import java.lang.reflect.Array;
import java.util.LinkedList;

public class GetName {

	public static void main(String[] args) {
		System.out.println(GetName.class.getName());
		System.out.println(int[].class.getName());
		System.out.println(GetName[].class.getName());
		System.out.println(GetName.class.getPackage());
		
		
		Class cll = LinkedList.class;
		System.out.println(cll.getName());
		System.out.println(cll);
		System.out.println(cll.getSimpleName());
	}
}