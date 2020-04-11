package com.onmobile.javapractises;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class DuplicateNumbers {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskC {

	public void getDuplicates(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			if (arr[i] > 1)
				System.out.println(i);
	}

	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int[] arr = new int[1001];
		try {
			FileReader fileReader = new FileReader(new File("E:\\workspace\\topcoder\\JavaBestPractices\\src\\abc.txt"));
			BufferedReader reader = new BufferedReader(fileReader);
			String str = "";
			while ((str = reader.readLine()) != null) {
				int k = Integer.parseInt(str.trim());
				arr[k]++;
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		getDuplicates(arr);
	}
}