package com.onmobile.training;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class CollectionTest1 
{
	static Map <Character, ArrayList <Integer> > hmap = new HashMap <Character, ArrayList <Integer> > ();
	
	public static void solve(String str)
	{
		for(int i = 0; i < str.length(); i++)
		{
			if(hmap.containsKey(str.charAt(i)))
			{
				//ArrayList <Integer> lst = hmap.get(str.charAt(i));
				
				hmap.get(str.charAt(i)).add(i);
				//hmap.put(str.charAt(i), lst);
			}
			else
			{
				List <Integer> lst = new ArrayList <Integer> ();
				lst.add(i);
				hmap.put(str.charAt(i), (ArrayList<Integer>) lst);
			}
		}
		System.out.print("{"); int cnt = 0;
		for(Character ch : hmap.keySet())
		{
			System.out.print(ch + " = ");
			System.out.print("[ ");
			ArrayList <Integer> lst = hmap.get(ch);
			for(int i = 0; i < lst.size(); i++)
			{
				System.out.print(lst.get(i) + " ");
				if(i < lst.size() - 1) System.out.print(",");
			}
			if(cnt < hmap.size() - 1) System.out.print("], ");
			else System.out.print("]  ");
			cnt++;
		}
		System.out.println("}");
	}
	
	public static void main(String[] args) 
	{
		String str = "";
		for(int i = 0; i < args.length; i++) str += args[i];
		solve(str);
	}
}
