package com.adobe.test;

public class Gcd {
	public static void main(String[] args) {
		int a = 10; int b = 20;
		int ans = findGcd(a, b);
		int sna = findGcdIterative(a, b);
		System.out.println(ans + "   " +  sna);
	}
	
	private static int findGcd(int a, int b) {
		if (a % b == 0) {
			return b;
		}
		return findGcd(b, a % b);
	}
	
	private static int findGcdIterative(int a, int b) {
		if (a < b) {
			int t = a;
			a = b;
			b = t;
		}
		while(a % b != 0) {
			int t = b;
			b = a % b;
			a = t;
		}
		return b;
	}
}
