package com.adobe.reflection;

import java.lang.reflect.Modifier;
import java.util.Collection;


/**  
 * Demonstrates how to get declaration information on a Class.
 *
 * @author <a href=mailto:kraythe@arcor.de>Robert Simmons jr. (kraythe)</a>
 * @version $Revision: 1.3 $
 */
public class DeclarationInfoDemo {
  /** 
   * Demonstration Method.
   *
   * @param args Command line arguments.
   */
  public static void main(final String[] args) {
    printModifiers(Object.class);
    printModifiers(Float.class);
    printModifiers(Collection.class);

    printModifiers(int.class);
    printModifiers(String.class);
  }

  /** 
   * Prints out the modifiers for a class.
   *
   * @param dataType The class for which to print out modifiers.
   */
  public static void printModifiers(final Class dataType) {
    final int modifiers = dataType.getModifiers();
    if (Modifier.isPrivate(modifiers)) {
      System.out.print("private ");
    }
    if (Modifier.isProtected(modifiers)) {
      System.out.print("protected ");
    }
   
    if (Modifier.isPublic(modifiers)) {
      System.out.print("public ");
    }
    if (Modifier.isAbstract(modifiers)) {
      System.out.print("abstract ");
    }
    if (Modifier.isFinal(modifiers)) {
      System.out.print("final ");
    }
    if (Modifier.isNative(modifiers)) {
      System.out.print("native ");
    }
    if (Modifier.isInterface(modifiers)) {
      System.out.print("interface ");
    }
    if (Modifier.isStatic(modifiers)) {
      System.out.print("static ");
    }
    if (Modifier.isStrict(modifiers)) {
      System.out.print("strict ");
    }
    if (Modifier.isSynchronized(modifiers)) {
      System.out.print("synchronized ");
    }
    if (Modifier.isTransient(modifiers)) {
      System.out.print("transient ");
    }
    if (Modifier.isVolatile(modifiers)) {
      System.out.print("volatile ");
    }
    System.out.println(dataType.getName());
  }
}
