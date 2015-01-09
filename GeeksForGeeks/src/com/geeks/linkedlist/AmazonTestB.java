package com.geeks.linkedlist;

public class AmazonTestB {
	public static void main(String[] args) {
		Node head = Node.createLinkedList();
		Node kk = sortList(head);
		head.print();
	}
	
	private static Node sortList(Node l1){
		//it is using no extra space.
		// just maintaining everything with reference..
		Node first = l1;
		Node second = l1;
		Node myAnswer = first;
		
		Node temp = l1;
		while (temp.next != null) {
			Node ahead = temp.next;
			if (temp.data > ahead.data) {
				second = ahead;
				break;
			}
			temp = temp.next;
		}
		if (first == second) {
			return l1; // meaning only one incresing sequence..
		}
		temp = second;
		while (first != null && second != null) {
			if (first == second && second.next != null) {
				second = second.next;
			}
			if (first.data > second.data) {
				int kk = first.data;
				first.data = second.data;
				second.data = kk;
				first = first.next;
			}
			else if (first.data <= second.data) {
				first = first.next;
			}			
		}
		return myAnswer;
	}
}
