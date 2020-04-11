package com.onmobile.training.complexpair;

import java.util.Comparator;

public class Pair <T extends Number, E extends Number> implements Comparable <Pair <Number,Number> >
{
	private T first;
	private E second;
	
	public Pair(T first, E second) {
		super();
		this.first = first;
		this.second = second;
	}

	public T getFirst() {
		return first;
	}

	public E getSecond() {
		return second;
	}

	@Override
	public String toString() {
		return "Pair [first=" + first + ", second=" + second + "]";
	}

	@Override
	public int compareTo(Pair<Number, Number> o) {
		int comp = 0;
		if(first.doubleValue() + second.doubleValue() < o.first.doubleValue() + o.second.doubleValue())
		{
			comp = -1;
		}
		if(first.doubleValue() + second.doubleValue() > o.first.doubleValue() + o.second.doubleValue())
		{
			comp = 1;
		}
		return comp;
	}
}
