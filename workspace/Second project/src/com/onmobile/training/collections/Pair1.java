package com.onmobile.training.collections;

public class Pair1 <T> {
	private int first;
	private int second;
	
	public Pair1(int first, int second) {
		super();
		this.first = first;
		this.second = second;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	@Override
	public String toString() {
		return "Pair [first=" + first + ", second=" + second + "]";
	}
	
}
