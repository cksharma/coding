package com.onmobile.training;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GenericsTest 
{
	public static void main(String[] args) 
	{
		Map <String, Map <String, Map <String, Set <String> > > > players = new HashMap <String,  Map <String, Map <String, Set <String> > > >();
		Set <String> kar = new HashSet <String> ();
		Set <String> and = new HashSet <String> ();
		kar.add("Rahul Dravid");
		kar.add("Abhinav Mithun");
		and.add("VVS Laxman");
		and.add("Pragyan Ojha");
		Map <String, Set <String> > southZone = new HashMap <String, Set <String> > ();
		southZone.put("Karnataka", kar);
		southZone.put("Andhra",and);
		Map <String, Map <String, Set <String> > > india = new HashMap <String, Map <String, Set <String> > > ();
		india.put("South Zone", southZone);
		players.put("India", india);
		System.out.println("Players from Karnataka");
		Set <String> set = players.get("India").get("South Zone").get("Karnataka");
		for(String s : set)
		{
			System.out.println(s);
		}
	}
}
