package com.onmobile.javapractises;

class Dualton {
	private static Dualton[] first ;
	private static final int n = 10;
	private static int turn;
	private Dualton() {
		super();
		first = new Dualton[n];
	}
	
	public static Dualton getInstance() {
		if (turn >= n) turn = 0;
		return first[turn++];
	}
}

public class SingletonPattern {
	public static void main(String[] args) {
		
	}
}

