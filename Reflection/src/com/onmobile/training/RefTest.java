package com.onmobile.training;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class RefTest 
{
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the class name");
		String clsName = s.nextLine(); // class name is stored in the clsName .. but how can i form the object for this class..
		//for such purpose we use Reflection...class name should be specified with the package..
					
		try {
			Class cls = Class.forName(clsName);
			Object obj = cls.newInstance();
			System.out.println(obj);
			
			/*Field[] fields = cls.getDeclaredFields();
			System.out.println("Declared variables");
			for(Field f : fields)
			{
				System.out.println(f);
			}
			Method[] methods = cls.getDeclaredMethods();
			System.out.println("Declared Methods");
			for(Method m : methods)
			{
				System.out.println(m);
			}
			Constructor[] constructors = cls.getDeclaredConstructors();
			System.out.println("Constructors ");
			for(Constructor c : constructors)
			{
				System.out.println(c);
			}
			System.out.println();
			System.out.println();*/
			System.out.println("Enter the method Name"); // u can comment all the above code if u wish..
			String methodName = s.nextLine();
		    
			Method method = cls.getDeclaredMethod(methodName, String.class); // if the method takes the parameters we can pass then as varargs..
			method.invoke(obj, "Rajesh"); // we are invoking the method and for the object obj....
			
			/*Method[] methods = cls.getDeclaredMethods();
			for(Method method : methods)
			{
				if(method.getName().equals(methodName))
				{
					method.invoke(obj, "Raju");
				}
			}*/
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
