package com.geeks.string;

public class StringPermutation {
	public static void main(String[] args) {
		String str = "abc";
		permutation("", str);
	}
	private static void permutation(String beginStr, String endStr) {
		if (endStr.length() <= 1) {
			System.out.println(beginStr + endStr);
		} else {
			for (int i = 0; i < endStr.length(); i++) {
				String newEndStr = endStr.substring(0, i) + endStr.substring(i + 1);
				permutation(beginStr + endStr.charAt(i), newEndStr);
			}
		}			
	}
}
