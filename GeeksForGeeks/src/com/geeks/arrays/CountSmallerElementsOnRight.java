package com.geeks.arrays;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class CountSmallerElementsOnRight {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskCountSmallerRight solver = new TaskCountSmallerRight();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskCountSmallerRight {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int n = in.nextInt();
		int[] arr = new int[n];
		int[] output = new int[n];
		output[output.length - 1] = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		AVLTree root = new AVLTree(arr[n - 1]);
		for (int i = n - 2; i >= 0; i--) {
			root = root.insert(arr[i]);
		}
		System.out.println(root.data);
		root.printTree(root);	
	}	
}