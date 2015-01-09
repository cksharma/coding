package com.geeks.linkedlist;

import java.util.Scanner;

public class SwapKLastFirst {
	
	static Node swapK(Node node, int K) {
		int SZ = 0;
		if (K < 0 || K > (SZ = sizeOfLinkedList(node))) {
			return null;
		}
		int front = 1, rear = 1;
		Node head = node;
		Node ff = node;
		Node bb = node;
		while (front < K) {
			front++;
			ff = ff.next;
		}
		while (rear <= SZ - K) {
			rear++;
			bb = bb.next;
		}
		int F = ff.data;
		int B = bb.data;
		ff.data = B;
		bb.data = F;
		return head;
	}
	
	static int sizeOfLinkedList (Node node) {
		int ans = 0;
		while (node != null) { 
			ans++;
			node = node.next;
		}	
		return ans;
	}
	
	public static void main(String[] args) {
		Node node = Node.createLinkedList();
		Scanner in = new Scanner(System.in);
		int K = in.nextInt();
		swapK(node, K);
		node.print();
	}
}
