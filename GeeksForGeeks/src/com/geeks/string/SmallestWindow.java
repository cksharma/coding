package com.geeks.string;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashSet;

public class SmallestWindow {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		SmallestWindowTask solver = new SmallestWindowTask();
		solver.solve(1, in, out);
		out.close();
	}
}

class SmallestWindowTask {
	
	public String getTargetString(String ans)
	{
		HashSet <Character> hset = new HashSet <Character> ();
		for(char ch : ans.toCharArray()) hset.add(ch);
		String res = "";
		for(char item : hset) res += item;
		return res;
	}
	
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		String source = in.next();
		String target = getTargetString(source);
		int[] SC = new int[256];
		int[] TC = new int[256];
		for(char ch : source.toCharArray()) SC[ch]++;
		for(char ch : target.toCharArray()) TC[ch]++;
		
	}
}

