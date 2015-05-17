package com.onmobile.training;

class A {
	static int k = hello();

	static void print() {
		System.out.println(a);
	}

	static int a = 10;
	static {

		System.out.println(a + "first");

	}

	static int hello() {
		System.out.println("hello");
		return 0;

	}

	static int b = 20;
	static {
		System.out.println(a + "second");
		System.out.println(b + "third");
	}

	A() {

	}
}

public class StaticTest {

	public static void main(String[] args) {

		A.print();
	}

}
