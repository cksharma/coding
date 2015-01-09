package com.geeks.backtracking;

public class NQueens
{
	private static int n;
	private static int[] columns;
	
	public static void placeQueen(int row)
	{
		if(row == n - 1) // we have taken all the n rows.
		{
			for(int i = 0; i < n; i++) System.out.print("( " + i  + ", " + columns[i] + ") " );
			System.out.println();
		}
		else
		{
			if(isSafe(row))
			{	
				for(int i = 0; i < n; i++)
				{
					columns[row + 1] = i;
					placeQueen(row + 1);
				}
			}	
		}
	}
	
	public static boolean isSafe(int row)
	{
		int k = 0; boolean flag = true;
		while(k < row && flag)
		{
			if(columns[row] == columns[k] || Math.abs(columns[row] - columns[k]) == Math.abs(row - k))
				flag = false;
			k++;
		}
		return flag;
	}
	
	public static void main(String[] args)
	{
		n = 8;
		columns = new int[n];
		placeQueen(0);
	}
}
