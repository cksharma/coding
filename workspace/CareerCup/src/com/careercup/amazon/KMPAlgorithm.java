package com.careercup.amazon;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class KMPAlgorithm {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskKMP solver = new TaskKMP();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskKMP {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		String parent = in.next();
		String pattern = in.next();
		
		char[] par = parent.toCharArray();
		char[] pat = pattern.toCharArray();
		
		for (int i = 0; i < par.length; i++) {
			int index = 0;
			while (pat[index++] == par[i]) {
				
			}
		}
	}
}