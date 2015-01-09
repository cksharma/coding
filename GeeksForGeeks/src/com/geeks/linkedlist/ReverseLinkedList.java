package com.geeks.linkedlist;

public class ReverseLinkedList {
	public static void main(String[] args) {
		Node node = new Node(10);
		LinkedListUtility.insertNode(node, 12);
		LinkedListUtility.insertNode(node, 14);
		LinkedListUtility.insertNode(node, 16);
		LinkedListUtility.insertNode(node, 18);
		LinkedListUtility.printLinkedList(node);
		
		node = LinkedListUtility.reverseLinkedList(node);
		LinkedListUtility.printLinkedList(node);
	}
}
