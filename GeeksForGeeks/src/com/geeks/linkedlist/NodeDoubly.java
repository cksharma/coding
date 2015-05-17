package com.geeks.linkedlist;

class NodeDoubly {
	int data;
	NodeDoubly next;
	NodeDoubly prev;
	
	public NodeDoubly(int data) {
		super();
		this.data = data;
	}	
	public NodeDoubly insert(int x) {
		NodeDoubly node = this;
		while (node.next != null) {
			node = node.next;
		}
		node.next = new NodeDoubly(x);
		NodeDoubly ahead = node.next;
		ahead.prev = node;
		return node;		
	}
	
	public void printList() {
		NodeDoubly node = this;
		while (node != null) {
			System.out.print(node.data + " <==> ");
			node = node.next;
		}
		System.out.println();
	}
	public void printAsTree(NodeDoubly root) {
		if (root == null) return;
		printAsTree(root.prev);
		System.out.println(root.data);
		printAsTree(root.next);
	}
}