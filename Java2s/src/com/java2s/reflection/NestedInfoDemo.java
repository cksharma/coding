package com.java2s.reflection;

import java.util.Arrays;

import javax.swing.JTable;

/**  
 * Demonstrates fetching nested class info from a Class object.
 *
 * @author <a href=mailto:kraythe@arcor.de>Robert Simmons jr. (kraythe)</a>
 * @version $Revision: 1.3 $
 */
public class NestedInfoDemo {
  /** 
   * Demo method.
   *
   * @param args Command line arguments.
   */
  public static void main(final String[] args) {
    printMemberClasses(JTable.class);

  }

  /** 
   * Printo out member information for a class.
   *
   * @param dataType The class to work with.
   */
  public static void printMemberClasses(final Class dataType) {
    final Class[] nestedClasses = dataType.getClasses();
    final Class[] declaredNestedClasses = dataType.getDeclaredClasses();
    final Class[] nestedInterfaces = dataType.getInterfaces();
    final Class declaringClass = dataType.getDeclaringClass();

    // --
    System.out.println("Member Class infor for: " + dataType.getName());
    System.out.println("Nested Classes: " + Arrays.asList(nestedClasses));
    System.out.println("Declared Nested Classes: "
                       + Arrays.asList(declaredNestedClasses));
    System.out.println("Interfaces: " + Arrays.asList(nestedInterfaces));
    System.out.println("Declaring Class: " + declaringClass);
    System.out.println();
  }
}

/* ########## End of File ########## */