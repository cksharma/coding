package com.onmobile.training;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SimulateJavaProgram 
{
	public static void main(String[] args) 
	{
		Scanner ss = new Scanner(System.in);
		System.out.println("Enter the Java Class Name");
		String clsName = ss.nextLine();
		StringTokenizer stk = new StringTokenizer(clsName);
		String[] AA = new String[stk.countTokens() - 1];
		int index = 0;
		clsName = stk.nextToken();
		while(stk.hasMoreTokens())
		{
			AA[index++] = (String)stk.nextToken();
		}
		try {
			Class cls = Class.forName(clsName);
			Object obj = cls.newInstance();
			Method[] methods = cls.getDeclaredMethods();
			for(Method method : methods)
			{
				String returnType = method.getReturnType().toString();
				boolean first = Modifier.isPublic(method.getModifiers());
				boolean second = Modifier.isStatic(method.getModifiers());
				boolean third = method.getName().equals("main");
				if(third && first && second && returnType.equals("void") && method.getParameterTypes().length == 1)
				{
					Class abcd = method.getParameterTypes()[0];
					if(abcd.getSimpleName().equals("String[]") || abcd.getSimpleName().equals("String..."))
					{
						//method.invoke(obj, (Object)new String[]{});
						method.invoke(obj, (Object)AA);
					}
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
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
