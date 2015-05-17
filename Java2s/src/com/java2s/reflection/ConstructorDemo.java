package com.java2s.reflection;

import java.lang.reflect.Constructor;

/**
 * Demonstrates use of Constructor objects.
 * 
 * @author <a href=mailto:kraythe@arcor.de>Robert Simmons jr. (kraythe)</a>
 * @version $Revision$
 */
public class ConstructorDemo {
	/**
	 * Run the demo.
	 * 
	 * @param args
	 *            Command line arguments.
	 */
	public static void main(final String[] args) {
		try {
			final Class[] ARG_TYPES = new Class[] { String.class };

			Constructor cst = Integer.class.getConstructor(ARG_TYPES);

			System.out.println(cst.newInstance(new Object[] { "45" }));
		} catch (final Exception ex) {
			ex.printStackTrace();
		}
	}
}
