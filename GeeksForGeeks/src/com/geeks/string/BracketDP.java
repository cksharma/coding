package com.geeks.string;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BracketDP {

	private static Set<String> set = new HashSet<String>();

	public static void solve(int s, int n, String str) {
		if (s == n) {
			set.add(str);
			return;
		}	
		if (set.contains(str))
			return;
		for (int i = 0; i < str.length(); i++) {
			String ok = "("+  str.substring(0, i) + ")" + str.substring(i);
			solve(s + 1, n, ok);
		}
	}

	public static void main(String[] args) {
		System.out.println("Enter the Number of parenthesis pairs");
		Scanner si = new Scanner(System.in);
		int n = si.nextInt();
		solve(1, n, "()");
		for(String item : set) System.out.println(item);
	}
}
