package com.geeks.linkedlist;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class KthNodeFromLast {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		//TaskKthLast solver = new TaskKthLast();
		//solver.solve(1, in, out);
		LinkedList <Integer> ll = new LinkedList <Integer> (11);
		ll.add(21);
		ll.add(10);
		ll.add(14);
		ll.add(18);
		
		LinkedList <Integer> lll = KthNodeFromLastLinkedList.getKthNodeFromLast(ll, 4);
		System.out.println(lll.getValue());
		out.close();
	}
}

class TaskKthLast {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		System.out.println("Enter the numner of Elements");
		int n = in.nextInt();
		Node node = null;
		Node first = null;
		System.out.println("Enter the elements");
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				node = new Node(in.nextInt());
				first = node;
			} else {
				node = node.insert(in.nextInt());
			}	
		}
		int count = countNodes(first);
		System.out.println("Enter the value of K");
		Node second = first;
		int k = in.nextInt();
		assert k < count && k > 0 : "Wrong value for K";
		while (k-- > 0) {
			second = second.next;
		}
		while (second != null) {
			first = first.next;
			second = second.next;
		}
		first.print();
	}
	public int countNodes(Node node) {
		int cnt = 0;
		while (node != null) {
			node = node.next;
			cnt++;
		}
		return cnt;
	}
}

class KthNodeFromLastLinkedList {
	public static <T> LinkedList<T> getKthNodeFromLast (LinkedList <T> ll, int k) {
		LinkedList <T> backNode = ll;
		LinkedList <T> fronNode = ll;
		
		while (fronNode != null && k-- > 0) {
			fronNode = fronNode.next();			
		}
		
		if (k > 0) {
			throw new RuntimeException("Value of K cannot be greater than the size of LinkedList");
		}
		
		while (backNode != null && fronNode != null) {
			backNode = backNode.next();
			fronNode = fronNode.next();
		}
		return backNode;
	}
}