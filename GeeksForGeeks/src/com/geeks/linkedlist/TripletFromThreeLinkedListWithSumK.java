package com.geeks.linkedlist;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class TripletFromThreeLinkedListWithSumK {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskTriplet solver = new TaskTriplet();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskTriplet {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		System.out.println("Enter the number of elements in First LL");
		int f = in.nextInt();
		System.out.println("Enter the those elements");
		Node first = new Node(in.nextInt());
		Node head1 = first;
		for (int i = 1; i < f; i++) 
			first = first.insert(in.nextInt());
		System.out.println("Enter the number of elements in Second LL");
		int s = in.nextInt();
		System.out.println("Enter those elements");
		Node second = new Node(in.nextInt());
		Node head2 = second;
		for (int i = 1; i < s; i++) 
			second = second.insert(in.nextInt());
		System.out.println("Enter the number of elements in Third LL");
		int t = in.nextInt();
		System.out.println("Enter those elements");
		Node third = new Node(in.nextInt());
		Node head3 = third;
		for (int i = 1; i < t; i++) 
			third = third.insert(in.nextInt());
		System.out.println("Enter the desired sum K");
		int K = in.nextInt();
		head2 = LinkedListUtility.sortLinkedList(head2);
		head3 = LinkedListUtility.sortLinkedList(head3);
		head3 = LinkedListUtility.reverseLinkedList(head3, null);
		head1.print();
		head2.print();
		head3.print();
		
	}
}
