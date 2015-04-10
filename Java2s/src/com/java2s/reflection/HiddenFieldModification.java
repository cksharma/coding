package com.java2s.reflection;

/* file: HiddenFieldModification.java
 * package: oreilly.hcj.reflection
 *
 * This software is granted under the terms of the Common Public License,
 * CPL, which may be found at the following URL:
 * http://www-124.ibm.com/developerworks/oss/CPLv1.0.htm
 *
 * Copyright(c) 2003-2005 by the authors indicated in the @author tags.
 * All Rights are Reserved by the various authors.
 *
 ########## DO NOT EDIT ABOVE THIS LINE ########## */

import java.lang.reflect.Field;

/**
 * Demonstrates how to set public field objects.
 * 
 * @author <a href=mailto:kraythe@arcor.de>Robert Simmons jr. (kraythe)</a>
 * @version $Revision: 1.3 $
 */
public class HiddenFieldModification {
	/**
	 * Sets all int fields in an object to 0.
	 * 
	 * @param obj
	 *            The object to operate on.
	 * 
	 * @throws RuntimeException
	 *             If there is a reflection problem.
	 */
	public static void initIntFields(final Object obj) {
		try {
			Field[] fields = obj.getClass().getDeclaredFields();
			for (int idx = 0; idx < fields.length; idx++) {
				if (fields[idx].getType() == int.class) {
					fields[idx].setAccessible(true);
					fields[idx].setInt(obj, 0);
				}
			}
		} catch (final IllegalAccessException ex) {
			throw new RuntimeException(ex);
		}
	}

	/**
	 * Demo Method.
	 * 
	 * @param args
	 *            Command line arguments.
	 */
	public static final void main(final String[] args) {
		Integer value = new Integer("123");
		System.out.println("Before: " + value);
		initIntFields(value);
		System.out.println("After: " + value);
	}
}

/* ########## End of File ########## */