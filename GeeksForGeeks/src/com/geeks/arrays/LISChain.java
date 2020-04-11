package com.geeks.arrays;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;

public class LISChain {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskC {	
	
	static class Pair {
		int first;
		int second;
	}	
	
	public int getMaximumValue(int[] length) {
		int ans = 0;
		for (int i = 0; i < length.length; i++) {
			ans = Math.max(ans, length[i]);
		}
		return ans;
	}
	
	public int getIndexLIS(int count, int[] length) {
		int index = -1;
		for (int i = 0; i < length.length; i++) {
			if(length[i] == count) {
				index = i;
			}	
		}
		return index;
	}
	
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int n = in.nextInt();
		Pair[] arr = new Pair[n];
		for (int i = 0; i < n; i++) {
			Pair p = new Pair();
			p.first = in.nextInt();
			p.second = in.nextInt();
			arr[i] = p;
		}
		int[] length = new int[n];
		int[] parent = new int[n];
		
		Arrays.fill(length, 1);
		Arrays.fill(parent, -1);
		
		for (int i = 1; i < n; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if(arr[i].first > arr[j].second && length[i] <= length[j]) {
					length[i] = length[j] + 1;
					parent[i] = j;
				}
			}
		}
		int lisCount = getMaximumValue(length);
		System.out.println("Count Chain " + lisCount);
		int index = getIndexLIS(lisCount, length);
		Pair[] ans = new Pair[lisCount];
		while(index != -1) {
			Pair p = new Pair();
			p.first = arr[index].first;
			p.second = arr[index].second;
			ans[--lisCount] = p;
			index = parent[index];
		}
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i].first + " " + ans[i].second);
		}
	}
}
