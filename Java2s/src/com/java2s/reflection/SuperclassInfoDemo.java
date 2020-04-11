package com.java2s.reflection;

import java.util.Set;

import javax.swing.JDialog;

/**
 * Demonstrates getting immediate superclass info.
 * 
 * @author <a href=mailto:kraythe@arcor.de>Robert Simmons jr. (kraythe)</a>
 * @version $Revision: 1.3 $
 */
public class SuperclassInfoDemo {
	/**
	 * Demon method.
	 * 
	 * @param args
	 *            Command line arguments.
	 */
	public static void main(final String[] args) {
		System.out.println("JDialog --|> " + JDialog.class.getSuperclass());
		System.out.println("Integer --|> " + Integer.class.getSuperclass());
		System.out.println("Object --|> " + Object.class.getSuperclass());
		System.out.println("int --|> " + int.class.getSuperclass());
		System.out.println("int[] --|> " + int[].class.getSuperclass());
		System.out.println("Set --|> " + Set.class.getSuperclass());
		System.out.println("Comparable --|> " + Comparable.class.getSuperclass());
		
		Integer k = 10;
		System.out.println(k.getClass().getSuperclass());
	}
}
