package com.geeks.zdummy;

import java.util.Scanner;

public class LuckNumberRecursion {
	private static int ans;
	private static int n;
	
	private static void solve(int f, int s, boolean four) {
		if (f <= n && four) {
			ans++;
			System.out.print(f + "   ");
			solve(f * 10 + 4, s, four);
			solve(f * 10 + 7, s, four);
		}		
		else if (s <= n && !four) {
			ans++;
			System.out.print(s + "   ");
			solve(f, s * 10 + 4, four);
			solve(f, s * 10 + 7, four);
		}
	}
	
	public static void main(String[] args) {
		Scanner ss = new Scanner(System.in);
		n = ss.nextInt();
		ss.close();
		solve(4, 7, true);
		solve(4, 7, false);
		System.out.println("ans = " + ans);
	}
}
