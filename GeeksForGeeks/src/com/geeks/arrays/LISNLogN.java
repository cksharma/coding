package com.geeks.arrays;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class LISNLogN {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskLISNLogN solver = new TaskLISNLogN();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskLISNLogN {	
	
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int[] arr = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		int[] lisArr = new int[arr.length];
		
		int len = 1;
		lisArr[0] = arr[0];
		for (int index = 1; index < arr.length; index++) {
			int key = arr[index];
			if (key < lisArr[0]) {
				lisArr[0] = key;
			} else if (key > lisArr[len - 1]) {
				lisArr[len++] = key;
			} else {
				lisArr[manageBinarySearch(lisArr, -1, len - 1, key)] = key;
			}
		}
		out.println(len);
	}

	private int manageBinarySearch(int[] lisArr, int l, int r, int key) {
		int middle = -1;
		while (r - l > 1) {
			middle = l + (r - l) / 2;
			if (lisArr[middle] >= key) {
				r = middle;
			} else {
				l = middle;
			}
		}
		return r;
	}	
}
