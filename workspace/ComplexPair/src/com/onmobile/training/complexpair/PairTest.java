package com.onmobile.training.complexpair;
import java.util.TreeSet;
import java.util.Set;

public class PairTest 
{
	public static void main(String[] args) 
	{
		TreeSet <Pair <Integer, Integer> > tset = new TreeSet <Pair <Integer, Integer> > (new PairComparator());
		tset.add(new Pair(12, 22));
		tset.add(new Pair(23, 44));
		tset.add(new Pair(12, 11));
		tset.add(new Pair(23, 02));
		for(Pair<Integer, Integer> p : tset)
		{
			System.out.println(p);
		}
	}
}
