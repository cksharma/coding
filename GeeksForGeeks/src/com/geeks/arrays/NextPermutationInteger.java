package com.geeks.arrays;

import java.util.Arrays;

public class NextPermutationInteger {
	static class Permutation {
		public static boolean nextPermutation(Integer[] p) {
			int a = p.length - 2;
			while (a >= 0 && p[a].compareTo(p[a + 1]) >= 0) {
				a--;
			}
			if (a == -1) {
				return false;
			}
			int b = p.length - 1;
			while (p[b].compareTo(p[a]) <= 0) {
				b--;
			}
			Integer t = p[a];
			p[a] = p[b];
			p[b] = t;
			for (int i = a + 1, j = p.length - 1; i < j; i++, j--) {
				t = p[i];
				p[i] = p[j];
				p[j] = t;
			}
			return true;
		}
	}
	public static void main(String[] args) {
		Integer[] integer = {1, 2, 3 };
		while (Permutation.nextPermutation(integer)) {
			System.out.println(Arrays.toString(integer));
		}
	}
}
