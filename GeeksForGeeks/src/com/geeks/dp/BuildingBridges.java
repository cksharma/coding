package com.geeks.dp;

import static java.lang.Math.max;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class BuildingBridges {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskBuildBridge solver = new TaskBuildBridge();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskBuildBridge {
	static class Pair {
		int x;
		int y;
		@Override
		public String toString() {
			return "(" + x + ", " + y + ")";
		}		
	}
	private int getIt(int ans, int[] arr) {
		int index = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == ans) {
				index = i;
				break;
			}
		}
		return index;		
	}
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int[] one = new int[] {8, 1, 4, 3, 5, 2, 6, 7};
		int[] two = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
		Pair[] pair = new Pair[one.length];
		for (int i = 0; i < two.length; i++) {
			Pair p = new Pair();
			p.x = getIt(two[i], one);
			p.y = i;
			pair[i] = p;
		}
		int[] dp = new int[pair.length];
		Arrays.fill(dp, 1);
		int[] parent = new int[pair.length];
		Arrays.fill(parent, -1);
		for (int i = 1; i < pair.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (pair[i].x > pair[j].x && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
					parent[i] = j;
				}
			}
		}
		for (int i = 0; i < pair.length; i++) System.out.println(pair[i]);
		int ans = -1;
		for (int i = 0; i < dp.length; i++) ans = max(ans, dp[i]);
		System.out.println(ans);
		int index = -1;
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] == ans) {
				index = i;
				break;
			}
		}
		List <Integer> list = new ArrayList <Integer> (ans);
		while (index != -1) {
			list.add(two[index]);
			index = parent[index];
		}
		Collections.reverse(list);
		System.out.println(list);
	}
}
