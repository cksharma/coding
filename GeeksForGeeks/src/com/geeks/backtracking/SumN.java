package com.geeks.backtracking;

public class SumN
{
	private static int n;
	private static int[] a;
	private static int[] visited;
	
	public static void solve(int index, int remSum)
	{
		if(remSum == 0)
		{
			for(int i = 0; i < index; i++)
			{
				System.out.print(a[i] + " ");
			}
			System.out.println();
		}
		else if(remSum > 0)
		{
			for(int i = 1; i <= n - 1; i++)
			{
				a[index] = i;
				solve(index + 1, remSum - i);
			}
		}
	}
	
	public static void main(String[] args)
	{
		n = 4;
		a = new int[n];
		visited = new int[n];
		solve(0, n);
	}
}
