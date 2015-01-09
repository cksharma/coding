package com.geeks.string;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class NthFibonacci {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		SolveNthFibonacci solver = new SolveNthFibonacci();
		solver.solve(1, in, out);
		out.close();
	}
}

class SolveNthFibonacci {
	int[] dp;
	public int fibonacci(int n)
	{
		if(n == 0) return dp[0] = 0;
		if(n == 1) return dp[1] = 0;
		if(n == 2) return dp[2] = 1;
		if(n == 3) return dp[3] = 1;
		if(dp[n] > 0) return dp[n];
		
		if(n % 2 == 0)
			return dp[n] = (int)Math.pow(fibonacci(n / 2), 2.) + (int)Math.pow(fibonacci(n / 2 + 1), 2.);
		else return dp[n] = (2 * fibonacci(n / 2 + 2) - fibonacci(n / 2 + 1) ) * fibonacci(n / 2 + 1);
	}
	
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int n = in.nextInt();
		dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		int ans = fibonacci(n);
		System.out.println(ans);
	}
}
