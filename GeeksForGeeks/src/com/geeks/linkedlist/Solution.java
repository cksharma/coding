package com.geeks.linkedlist;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskLoop solver = new TaskLoop();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskLoop {
	
	
	static int numElements(Node h1) {
		/*
		   Structure of each node
		   class Node {
		       Node next;
		       int val;
		   };
		The above structure has already been defined, please do NOT redefine, you can just start using as Node x; 

		*/
		int ans = 0;
		if (detectLoop(h1)) {
			Map <Integer, Boolean> map = new HashMap <Integer, Boolean> ();
			while (h1 != null) {
				if (map.containsKey(h1.data)) {
					break;
				}
				ans++;
				map.put(h1.data, true);
				h1 = h1.next;
			}
		} else {
			ans = sizeOfLinkedList(h1);
		}
		return ans;
	}
	
	public static boolean detectLoop(Node h1) {
		Node slow = h1;
		Node fast = h1;
		while (slow != null && fast != null) {
			slow = slow.next;
			fast = fast.next;
			if (fast == null) return false;
			fast = fast.next;
			if (fast == null) return false;
			if (slow == fast) {
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
	
	
/*	static int numElements(Node h1) {
		
		   Structure of each node
		   class Node {
		       Node next;
		       int val;
		   };
		The above structure has already been defined, please do NOT redefine, you can just start using as Node x; 

		
		Set <Integer> set = new HashSet <Integer> ();
		int ans = 0;
		while (true) {
			if (h1 == null) 
				break;
			int currentValue = h1.val;
			if (set.contains(currentValue)) {
				break;
			}
			set.add(currentValue);
			h1 = h1.next;
			ans++;
		}
		return ans;
	}*/
	
	/*public static boolean detectLoop(Node h1) {
		Node slow = h1;
		Node fast = h1;
		while (slow != null && fast != null) {
			slow = slow.next;
			fast = fast.next;
			if (fast == null) return false;
			fast = fast.next;
			if (fast == null) return false;
			if (slow.val == fast.val) {
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
	}*/
	
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		Node n1 = Node.createLinkedList();
		System.out.println(numElements(n1));
	}
}