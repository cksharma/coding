package com.geeks.linkedlist;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class DoublyLinkedList {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskDoublyLL solver = new TaskDoublyLL();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskDoublyLL {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		System.out.println("Enter the number of elements");
		int n = in.nextInt();
		System.out.println("Now enter the elements");
		NodeDoubly node = new NodeDoubly(in.nextInt());
		NodeDoubly head = node;
		for (int i = 1; i < n; i++) {
			node = node.insert(in.nextInt());
		}
		head.printList();
	}
}