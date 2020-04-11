package com.adobe.reflection;

import java.lang.reflect.Method;

/**  
 * Demonstrates the use of <tt>getDeclaringClass()</tt>.
 *
 * @author <a href=mailto:kraythe@arcor.de>Robert Simmons jr. (kraythe)</a>
 * @version $Revision: 1.3 $
 */
public class DeclaringClassDemo {
  /** 
   * Demo method.
   *
   * @param args Command line arguments.
   */
  public static void main(final String[] args) {
    Method[] methods = String.class.getMethods();
    for (int idx = 0; idx < methods.length; idx++) {
      System.out.println(methods[idx] + " declared by "
                         + methods[idx].getDeclaringClass());
    }
  }
}