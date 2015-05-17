package com.geeks.linkedlist;

import java.util.Scanner;

class Node {
	int data;
	Node next;

	public Node(int val) {
		super();
		this.data = val;
	}
	
	public Node() {
		super();	
	}

	public Node insert(int val) {
		Node node = new Node(val);
		this.next = node;
		return node;
	}
	
	public void print() {
		Node node = this;
		while (node != null) {
			System.out.print(node.data + " -> ");
			node = node.next;
		}
		System.out.println();
	}
	public static Node createLinkedList() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of nodes");
		int n = in.nextInt();
		assert n > 0 : "Number of nodes should be > 0";
		System.out.println("Now enter nodes");
		Node node = new Node(in.nextInt());
		Node original = node;
		for (int i = 1; i < n; i++) {
			node = node.insert(in.nextInt());
		}
		return original;
	}
}
