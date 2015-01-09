package com.geeks.arrays;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FourElementsThatSumToGivenValueNSquareLogN {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskFourSumGet solver = new TaskFourSumGet();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskFourSumGet {
	static class Test implements Comparable<Test>{
		int i;
		int j;
		int sum;		
		public Test(int i, int j, int sum) {
			super();
			this.i = i;
			this.j = j;
			this.sum = sum;
		}
		@Override
		public int compareTo(Test arg) {
			int res;
			if (sum < arg.sum) res = -1;
			else if (sum > arg.sum)res = 1; 
			else res = 0;
			return res;
		}
	}
	
	Map <String, Boolean> map = new HashMap <String, Boolean>();
	
	private void getAllFourElements (Test[] test, int sum, int[] arr) {
		int i = 0, j = test.length - 1;
		int[] ans = new int[4];
		while (i < j) {
			int firstTwo = test[i].sum;
			int lastTwo = test[j].sum;
			if (test[i].i != test[j].i && test[i].i != test[j].j && test[i].j != test[j].j && test[i].j != test[j].i) {
				if (firstTwo + lastTwo == sum) {
					ans[0] = test[i].i;
					ans[1] = test[i].j;
					ans[2] = test[j].i;
					ans[3] = test[j].j;
					String str = arr[ans[0]] + "" + arr[ans[1]] + "" + arr[ans[2]] + "" + arr[ans[3]];
					char[] ch = str.toCharArray();
					Arrays.sort(ch);
					str = new String(ch);
					if (map.containsKey(str)) continue;
					map.put(str, true);
					System.out.println(arr[ans[0]] + " " + arr[ans[1]] + " " + arr[ans[2]] + " " + arr[ans[3]]);
					i++; j--;
				} else if(firstTwo + lastTwo > sum) {
					j--;
				} else {
					i++;
				}
			}
			else if (firstTwo + lastTwo > sum) {
				j--;
			}
			else {
				i++;
			}
		}		
	}	
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) arr[i] = in.nextInt();
		int sum = in.nextInt();
		Test[] test = new Test[(n * (n - 1)) / 2];
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				test[index++] = new Test(i, j, arr[i] + arr[j]);
			}
		}
		
		Arrays.sort(test);	
		
		getAllFourElements(test, sum, arr);
			
	}	
}