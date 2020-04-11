package com.geeks.linkedlist;

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


