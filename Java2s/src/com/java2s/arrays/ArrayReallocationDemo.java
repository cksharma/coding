package com.java2s.arrays;

import java.util.Arrays;

public class ArrayReallocationDemo {

	public static void main(String[] args) {
		int[] data1 = new int[] { 1, 3, 5, 7, 9 };

		printArray(data1);
		System.out.println(Arrays.toString(data1));
		int[] data2 = Arrays.copyOf(data1, 1);
		//data2[5] = 11;
		printArray(data2);
		System.out.println(Arrays.toString(data2));
		int[] data3 = Arrays.copyOfRange(data1, 2, 10);
		printArray(data3);
		System.out.println(Arrays.toString(data3));
	}

	// print array elements
	private static void printArray(int[] data) {
		StringBuilder stringBuilder = new StringBuilder("[");
		for (int i = 0; i < data.length; i++) {
			stringBuilder.append(data[i]);
			if (i < data.length - 1)
				stringBuilder.append(", ");
		}
		stringBuilder.append("]");
		System.out.println(stringBuilder);
	}
}