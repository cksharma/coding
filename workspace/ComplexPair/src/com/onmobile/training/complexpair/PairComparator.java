package com.onmobile.training.complexpair;

import java.util.Comparator;

public class PairComparator implements Comparator <Pair <Integer, Integer> >
{
	@Override
	public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) 
	{
		int comp = 0;
		if(o1.getFirst() + o1.getSecond() < o2.getFirst() + o2.getSecond()) comp = -1;
		else if(o1.getFirst() + o1.getSecond() > o2.getFirst() + o2.getSecond()) comp = 1;
		return comp;
	}
}
