package com.adobe.oobe;

class LinkedList <T> {
	private T value;
	private LinkedList <T> next;
	private LinkedList <T> prevNode;
	
	public LinkedList (T value) {
		this.value = value;
		this.prevNode = this;
	}
	
	public void add(T value) {
		prevNode.next = new LinkedList <T> (value);
		prevNode = prevNode.next;
	}

	public T getValue() {
		return value;
	}
	
	public LinkedList <T> next() {
		return this.next;
	}
}

public class Main {
	public static void main(String[] args) {
		LinkedList <Integer> ll = new LinkedList <Integer> (10);
		ll.add(12);
		ll.add(19);
		ll.add(14);
		
		while (ll != null) {
			System.out.println(ll.getValue());
			ll = ll.next();
		}
	}
}