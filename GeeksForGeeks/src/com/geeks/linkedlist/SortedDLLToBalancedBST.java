package com.geeks.linkedlist;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class SortedDLLToBalancedBST {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskDLL solver = new TaskDLL();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskDLL {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		System.out.println("Lets form DLL");
		System.out.println("Enter the no of elements");
		int n = in.nextInt();
		NodeDoubly node = new NodeDoubly(in.nextInt());
		NodeDoubly head = node;
		for (int i = 1; i < n; i++) {
			node = node.insert(in.nextInt());
		}
		//head.printList();
		/*NodeDoubly middle = getMiddleNode(head);
		if (middle.next == null) head = null;
		//head.printList();
		NodeDoubly afterMiddle = middle.next;
		if (afterMiddle != null) afterMiddle.prev = null;
		
		middle.next = null;
		middle.prev = null;
		
		System.out.println("Middle" );
		middle.printList();
		System.out.println("Before");
		if (head != null) head.printList();
		System.out.println("After");
		if (afterMiddle != null) afterMiddle.printList();
		*/
		head = formBalancedBinarySearchTree(head);
		head.printAsTree(actualMiddle);
	}
	int i; NodeDoubly actualMiddle;
	public NodeDoubly formBalancedBinarySearchTree(NodeDoubly head) {
		if (head == null) return head;
		if (head.next == null) {
			head.prev = null;
			return head;			
		}
		NodeDoubly middle = getMiddleNode(head);
		NodeDoubly afterMiddle = middle.next;
		NodeDoubly beforeMiddle = head;
		
		if (middle.next == null) {
			beforeMiddle = null;
		}
		if (i == 0) {
			actualMiddle = middle;
		}
		i++;
		middle.prev = formBalancedBinarySearchTree(beforeMiddle);
		middle.next = formBalancedBinarySearchTree(afterMiddle);
		return middle;
	}

	public NodeDoubly getMiddleNode(NodeDoubly root) {
		if (root.next == null) {
			NodeDoubly ck = root;
			root = null;
			return ck;
		}	
		NodeDoubly fast = root;
		NodeDoubly slow = root;
		NodeDoubly afterMiddle = root;
		while (fast != null && fast.next != null) {
			fast = fast.next;
			fast = fast.next;
			if (fast == null || fast.next == null)
				break;
			slow = slow.next;
		}
		afterMiddle = slow.next;
		afterMiddle.prev = null;
		slow.next = null;
		return afterMiddle;
	}
}
