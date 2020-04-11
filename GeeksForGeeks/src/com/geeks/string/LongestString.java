package com.geeks.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LongestString {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Task solver = new Task();
		solver.solve(1, in, out);
		out.close();
	}
}

class Task {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		String str = in.next();
		int[] A = new int[256];
		int ans = 0;
		Arrays.fill(A, -1);
		int start = 0, end = 0;
		int len = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			int prev_index = A[ch];
			if (prev_index == -1 || i - prev_index > len) {
				len++;
				if (ans < len) {
					start = i - len;
					end = i;
				}
				ans = Math.max(ans, len);
			} else {
				if(ans < len) {
					start =  i - len;
					end = i;
				}
				ans = Math.max(ans, len);
				len = 0;
			}
			A[ch] = i;
		}
		System.out.println(str.substring(start, end));
		System.out.println(ans);
	}
}

class InputReader {
	private BufferedReader reader;
	private StringTokenizer tokenizer;

	public InputReader(InputStream stream) {
		reader = new BufferedReader(new InputStreamReader(stream));
		tokenizer = null;
	}

	public String next() {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			try {
				tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return tokenizer.nextToken();
	}

	public int nextInt() {
		return Integer.parseInt(next());
	}
}
