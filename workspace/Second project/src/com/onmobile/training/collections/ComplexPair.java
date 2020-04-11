package com.onmobile.training.collections;

public class ComplexPair <T, E> {
	private T first;
	private E second;
	public ComplexPair(T first, E second) {
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
	public E getSecond() {
		return second;
	}
	public void setSecond(E second) {
		this.second = second;
	}
	@Override
	public String toString() {
		return "ComplexPair [first=" + first + ", second=" + second + "]";
	}
	
}
