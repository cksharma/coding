package com.geeks.linkedlist;

public class Dummy {
	
	public static boolean detectLoop(Node h1) {
		Node slow = h1;
		Node fast = h1;
		while (slow != null && fast != null) {
			slow = slow.next;
			fast = fast.next;
			if (fast == null) return false;
			fast = fast.next;
			if (fast == null) return false;
			if (slow.data == fast.data) {
				return true;
			}
		}
		return false;
	}
	public static int sizeOfLinkedList(Node h1) {
		int ans = 0;
		while (h1 != null) {
			h1 = h1.next;
			ans++;
		} 
		return ans;
	}
	static int numElements(Node node) {
		int ans = 0;
		if (detectLoop(node)) {
			;
		} else {
			ans = sizeOfLinkedList(node);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Node node = Node.createLinkedList();
	}
}
