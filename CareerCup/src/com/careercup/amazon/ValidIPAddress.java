package com.careercup.amazon;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ValidIPAddress {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskIPAddress solver = new TaskIPAddress();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskIPAddress {
	
	public boolean isValid(String str) {
		int k = Integer.parseInt(str.trim());
		return k > 0 && k < 256;
	}
	
	public String processForValidIPAddress(int i, int j, int k, int l, String str) {
		String ans = "NA";
		int L = str.length(); 
		if (i + j + k + l != L)
			return ans;
		String first = str.substring(0, i);
		String second = str.substring(first.length(), first.length() + j);
		String third = str.substring(first.length() + second.length(), first.length() + second.length() + k);
		String fourth = str.substring(first.length() + second.length() + third.length(), first.length() + second.length() + third.length() +l);
		if (isValid(first) && isValid(second) && isValid(third) && isValid(fourth)) {
			ans = first + "." + second + "." + third + "." + fourth;
		}
		return ans;
	}
	
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		String str = in.nextLine();
		List <String> list = new ArrayList<String>();
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				for (int k = 1; k <= 3; k++) {
					for (int l = 1; l <= 3; l++) {
						String check = processForValidIPAddress(i, j, k, l, str);
						if (check.equals("NA")) continue;
						else list.add(check);
					}
				}
			}
		}
		for (String item : list) 
			System.out.println(item);
		if (list.size() == 0)
			System.out.println("NA");
	}
}
