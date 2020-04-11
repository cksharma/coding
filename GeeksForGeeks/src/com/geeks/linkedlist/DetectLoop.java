package com.geeks.linkedlist;

public class DetectLoop {
	public static void main(String[] args) {
		Node node = new Node(10);
		Node head = node;
		LinkedListUtility.insertNode(node, 12);
		Node node1 = LinkedListUtility.insertNode(node, 14);
		LinkedListUtility.insertNode(node, 16);
		Node node2 = LinkedListUtility.insertNode(node, 18);
		node2.next = node1;
		LinkedListUtility.printLinkedListWithLoop(node);
		
		boolean hasLoop = detectLoop(node);
		System.out.println(hasLoop);
	}
	
	private static boolean detectLoop(Node node) {
		if (node == null || node.next == null) return false;
		Node slow = node;
		Node fast = node;
		boolean flag = false;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if (slow.next == fast.next.next) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	
}
