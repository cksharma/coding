package com.java2s.reflection;

public class ObtainingClassInstances {
	/** An Integer object */
	protected static Integer someInteger = new Integer(10);

	/** A generic object. */
	protected static Object someObject = null;

	/** A String. */
	protected static String someString = new String("Hardcore Java");

	/** An int. */
	protected static int someInt = 15;

	/** An array of ints. */
	protected static int[] intArray = new int[] { 4, 5, 7, 9 };

	/**
	 * Main method.
	 * 
	 * @param args
	 *            Command line arguments.
	 */
	public static void main(final String[] args) {
		// -- Print out the Class instances.
		System.out.println(Integer.class);
		System.out.println(someString.getClass());
		System.out.println(intArray.getClass());
		System.out.println(Object.class);
		System.out.println(Integer.class);
		System.out.println(int.class);
		System.out.println(String.class);
		System.out.println(Comparable.class);
		System.out.println(Object[].class);

		// -- Things that WON'T work
		// System.out.println(someObject.getClass()); // <= Exception
		// System.out.println(someInt.getClass()); // <= Compiler errror
	}

	/**
	 * Demonstration of a method that doesnt check for null.
	 * 
	 * @param obj
	 *            The object passed.
	 */
	public void writeClass(final Object obj) {
		System.out.println(obj.getClass());
	}
}

/* ########## End of File ########## */
