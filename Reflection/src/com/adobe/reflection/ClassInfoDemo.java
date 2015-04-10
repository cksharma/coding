package com.adobe.reflection;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**  
 * Demonstrates usage of various class information methods.
 *
 * @author <a href=mailto:kraythe@arcor.de>Robert Simmons jr. (kraythe)</a>
 * @version $Revision: 1.3 $
 */
public class ClassInfoDemo {
  /** 
   * Demonstration Method
   *
   * @param args Demonstration Method.
   */
  public static void main(final String[] args) {
    final Set classes = new HashSet();
    classes.add(Class.class);
    classes.add(Comparable.class);
    classes.add(Serializable.class);
    classes.add(Integer.class);
    classes.add(int.class);
    classes.add(Float[].class);
    classes.add(String.class);
    classes.add(double[].class);
    classes.add(boolean.class);

    // --
    System.out.println("Finding interface Class objects in the set.");
    Iterator iter = classes.iterator();
    while (iter.hasNext()) {
      useIsInterface((Class)iter.next());
    }

    System.out.println("\nFinding primitive Class objects in the set.");
    iter = classes.iterator();
    while (iter.hasNext()) {
      useIsPrimitive((Class)iter.next());
    }

    System.out.println("\nFinding array Class objects in the set.");
    iter = classes.iterator();
    while (iter.hasNext()) {
      useIsArray((Class)iter.next());
    }
  }

  /** 
   * Demonstrates usage of <tt>isArray</tt> from Class.
   *
   * @param dataType The data type to check.
   *
   * @throws NullPointerException If the user passes null for dataType.
   */
  public static void useIsArray(final Class dataType) {
    if (dataType == null) {
      throw new NullPointerException();
    }
    if (dataType.isArray()) {
      System.out.print(dataType.getName());
      System.out.println("\t ==> " + dataType.getComponentType());
    }
  }

  /** 
   * Demonstrates usage of <tt>isInterface</tt> from Class.
   *
   * @param dataType The data type to check.
   *
   * @throws NullPointerException If the user passes null for dataType.
   */
  public static void useIsInterface(final Class dataType) {
    if (dataType == null) {
      throw new NullPointerException();
    }
    if (dataType.isInterface()) {
      System.out.println(dataType.getName());
    }
  }

  /** 
   * Demonstrates usage of <tt>isPrimitive</tt> from Class.
   *
   * @param dataType The data type to check.
   *
   * @throws NullPointerException If the user passes null for dataType.
   */
  public static void useIsPrimitive(final Class dataType) {
    if (dataType == null) {
      throw new NullPointerException();
    }
    if (dataType.isPrimitive()) {
      System.out.println(dataType.getName());
    }
  }
}

