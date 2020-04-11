package com.geeks.linkedlist;

public class PallindromeLinkedList {
	public static void main(String[] args) {
		Node node = new Node(10);
		LinkedListUtility.insertNode(node, 12);
		LinkedListUtility.insertNode(node, 14);
		LinkedListUtility.insertNode(node, 16);
		LinkedListUtility.insertNode(node, 14);
		LinkedListUtility.insertNode(node, 12);
		LinkedListUtility.insertNode(node, 10);
		LinkedListUtility.insertNode(node, 10);
		
		int nodeCount = 0;
		Node slow = node;
		Node fast = node;
		
		if (fast != null) nodeCount++;
		
		while (fast != null) {
			if (fast.next == null) {
				break;
			}
			fast = fast.next.next;
			
			if (fast == null) --nodeCount;
			
			slow = slow.next;
			nodeCount += 2;
		}
		System.out.println(nodeCount);
		System.out.println(slow.data);
	}
}
