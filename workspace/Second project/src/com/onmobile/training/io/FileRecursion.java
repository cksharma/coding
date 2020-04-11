package com.onmobile.training.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FileRecursion implements Runnable 
{
	
	int directory = 0;
	int file = 0;
	
	List <String> lstdir = new ArrayList <String> ();
	
	List <String> lstfile = new ArrayList <String> ();
	
	private void getIt(File f) 
	{
		String[] list = f.list();
		for (String s : list) 
		{
			File f1 = new File(f, s);
			if (f1.isDirectory()) 
			{
				directory++;
				lstdir.add(f1.getAbsolutePath());
				getIt(f1);
			}
			else if (f1.isFile()) 
			{
				lstfile.add(f1.getAbsolutePath());
				file++;
			}
		}
	}
	
	
	private void solve() throws IOException {
		File f = new File("E:/java programs");
		getIt(f);
		System.out.println("The directories are ");
		for(String str : lstdir) System.out.println(str);
		System.out.println();
		System.out.println("The files are");
		for(String str : lstfile) System.out.println(str);
		System.out.println("Directories number = " + directory);
		System.out.println("File number = " + file);
	}

	public static void main(String[] args) {
		new FileRecursion().run();
	}

	BufferedReader reader;
	StringTokenizer tokenizer;
	PrintWriter writer;

	public void run() {
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			tokenizer = null;
			writer = new PrintWriter(System.out);
			solve();
			reader.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	String nextToken() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}
}
