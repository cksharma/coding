package com.onmobile.training.collections;

public class ComplexPairTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ComplexPair <Integer, Float> pair1 = new ComplexPair <Integer, Float> (12, 3.44F);
		ComplexPair <Integer, String> pair2 = new ComplexPair <Integer, String> (11, "hello");
		ComplexPair <Double, Boolean> pair3 = new ComplexPair <Double, Boolean> (23.11, false);
		System.out.println(pair1);
		System.out.println(pair2);
		System.out.println(pair3);
	}
}
