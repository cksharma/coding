package com.geeks.arrays;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;

public class NumberOfTriangles {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskTriangle solver = new TaskTriangle();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskTriangle {
	
	private int arr[] =   {10, 21, 22, 100, 101, 200, 300};
	//private int arr[] =   {4, 10, 16, 35};
	
	//private int arr[] =   {5, 6, 7, 9, 10};
	
	//private int arr[] =   {5, 7, 8, 11, 12, 15};
	//private int arr[] =   {5, 6, 8, 11, 12};
	
	//private int arr[] =   {5, 6, 8, 11};
	
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		Arrays.sort(arr);
		int cnt = 0;
				
		for (int i = 0; i < arr.length - 2; i++) {
			int f = i;
			int len = arr.length - 1;
			int mid = arr.length - 2;
			int inc = 0;
			boolean flag = false;
			while (len >= f + 2 && mid >= f + 1) {
				if (arr[f] + arr[mid] > arr[len]) {
					inc++;
					//System.out.println(arr[f] + " " + arr[mid] + " " + arr[len] + " ");
					flag = true;
					if (mid == f + 1) {
						len--;
					} else
						mid--;
				}
				else {					
					len--;
					if (len <= mid) mid--;	
					
					if (flag) inc += len - mid - 1;
											
					flag = false;
				}
			}
			//System.out.println(inc);
			cnt += inc;
		}
		System.out.println(cnt);
	}
}
