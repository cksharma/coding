package com.geeks.linkedlist;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class RotateLinkedList {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskRotateLinkedList solver = new TaskRotateLinkedList();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskRotateLinkedList {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		Node node = Node.createLinkedList();
		System.out.println("Enter the Rotation K");
		int k = in.nextInt();
		assert k > 0 : "K should be > 0";
		Node move = node;
		while (k-- > 1) {
			move = move.next;
		}
		//System.out.println("print move");
		//move.print();
		Node remain = move.next;
		//System.out.println("print remain");
		//remain.print();
		move.next = null;
		System.out.println("print final list");
		Node ans = remain;
		while( remain != null && remain.next != null) {
			remain = remain.next;
		}
		remain.next = node;
		ans.print();
	}
}