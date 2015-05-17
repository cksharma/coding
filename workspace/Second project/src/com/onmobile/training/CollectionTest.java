package com.onmobile.training;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CollectionTest 
{
	
	static Map <String, Integer> hmap = new HashMap <String, Integer> ();
	
	public static int uniqueCharacters(String str)
	{
		if(hmap.containsKey(str)) return hmap.get(str);
		
		Set <Character> st = new HashSet <Character> ();
		
		for(int i = 0; i < str.length(); i++) 
		{
			st.add(str.charAt(i));
		}
		hmap.put(str,  st.size());
		return st.size();
	}
	
	public static void main(String[] args) 
	{
		System.out.println("Enter the number of strings");
		Scanner si = new Scanner(System.in);
		Scanner ss = new Scanner(System.in);
		int N = si.nextInt();
		for(int i = 0; i < N; i++)
		{
			System.out.println("Enter the string");	
			String str = ss.nextLine();
			int ans = uniqueCharacters(str);
			System.out.println("Unique characters in " + str + "  =  " + ans);
		}
	}
}
