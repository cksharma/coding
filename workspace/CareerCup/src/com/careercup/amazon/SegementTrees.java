package com.careercup.amazon;

import static java.lang.Math.max;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class SegementTrees {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskSegementTree solver = new TaskSegementTree();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskSegementTree {
	int[] arr;
	int[] tree;

	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int n = in.nextInt();
		arr = new int[n + 1];
		tree = new int[3 * n]; // generally segement tree size can be as much as
								// 2 * n + 1..
		for (int i = 1; i <= n; i++)
			arr[i] = in.nextInt();
		buildSegementTree(2, 1, n);
		for (int i = 1; i < 2 * n + 1; i++) {
			out.println(i + " -> " + tree[i] + "   ");
		}
	}

	public void buildSegementTree(int n, int s, int e) {
		if (s > e)
			return;
		if (s == e) {
			//System.out.println("sss" + s);
			tree[n] = arr[s];
			return;
		}
		buildSegementTree(2 * n, s, (s + e) / 2);
		buildSegementTree(2 * n + 1, (s + e) / 2 + 1, e);
		tree[n] = max(tree[2 * n], tree[2 * n + 1]);
		//System.out.println("ans " + n + "  " + tree[n]);
	}
	
	public void updateSegementTree(int n, int start, int end, int index, int val) {
		if (start > end || start > index || end < index ) return;
		 if (start==end) //at leaf node
		 {
		  tree[n] = val;
		  return;
		 }
	
		 updateSegementTree( n*2 , start , (start + end ) / 2 , index, val );
		 updateSegementTree( n*2 + 1 , (start + end) / 2 + 1 , end , index, val );
		 tree[n] = max( tree[n*2] , tree[n*2 + 1] );
	}
}
