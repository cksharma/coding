package com.java2s.reflection;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class SameSignature {

	public static boolean isSameSignature(Method methodA, Method methodB) {
		if (methodA == null)
			return false;
		if (methodB == null)
			return false;

		List parameterTypesA = Arrays.asList(methodA.getParameterTypes());
		List parameterTypesB = Arrays.asList(methodB.getParameterTypes());

		if (methodA.getName().equals(methodB.getName()) && parameterTypesA.containsAll(parameterTypesB))
			return true;

		return false;
	}
	
	public static void main(String[] args) {
		
	}
}
