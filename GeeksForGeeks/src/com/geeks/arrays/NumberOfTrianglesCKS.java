package com.geeks.arrays;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;

public class NumberOfTrianglesCKS {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskNumberOfTrianglesCKS solver = new TaskNumberOfTrianglesCKS();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskNumberOfTrianglesCKS {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int[] arr = new int[]{10, 21, 22, 100, 101, 200, 300};
		Arrays.sort(arr);
		int cnt = 0;
		for (int index = 0; index < arr.length; index++) {
			int sma = index;
			int lar = arr.length - 1;
			int mid = arr.length - 2;
			while (sma < lar && mid > sma) {
				if (arr[sma] + arr[mid] > arr[lar]) {
					out.println("{ " + arr[sma] + ", " + arr[mid] + ", " + arr[lar] + "}");
					mid--;
					cnt++;					
				} else {
					lar--;
					mid = lar - 1;
				}
			}
		}
		out.println(cnt);
	}
}