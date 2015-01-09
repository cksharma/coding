package com.geeks.string;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class RunLengthEncoding {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		RunLengthEncodingTask solver = new RunLengthEncodingTask();
		solver.solve(1, in, out);
		out.close();
	}
}

class RunLengthEncodingTask {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		String str = in.next();
		String ans = "";
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) != str.charAt(i - 1)) {
				ans += str.charAt(i - 1);
				ans += count + "";
				count = 1;
				if (i == str.length() - 1 && str.charAt(i - 1) != str.charAt(i)) {
					ans += str.charAt(i) + "" + count + "";
				}
			} else {
				count++;
				if (i == str.length() - 1 && str.charAt(i - 1) == str.charAt(i)) {
					ans += str.charAt(i) + "" + count + "";
				}
			}
		}
		if (str.length() == 1)
			System.out.println(str + "" + count);
		else
			System.out.println(ans);
	}
}
