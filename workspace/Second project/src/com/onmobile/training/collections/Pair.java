package com.onmobile.training.collections;

public class Pair <T extends Number> implements Comparable <Pair <Number> >
{
	private T first;
	private T second;
	
	public Pair(T first, T second) {
		super();
		this.first = first;
		this.second = second;
	}

	public T getFirst() {
		return first;
	}

	public void setFirst(T first) {
		this.first = first;
	}

	public T getSecond() {
		return second;
	}

	public void setSecond(T second) {
		this.second = second;
	}

	@Override
	public String toString() {
		return "Pair [first=" + first + ", second=" + second + "]";
	}

	@Override
	public int compareTo(Pair<Number> o) {
		// TODO Auto-generated method stub
		if(first.doubleValue() < o.first.doubleValue())
		{
			return -1;	
		}
		else if(first.doubleValue() > o.first.doubleValue())
		{
			return 1;
		}
		return 0;
	}

	
}
