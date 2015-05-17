package com.onmobile.training.collections;

public class Number1 {
	private int a;
	private int b;

	public Number1(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	public int hashCode() {
		System.out.println("Invoking hashCode");
		return a ^ b;
	}

	public String toString() {
		return ("[" + a + ", " + b + "]");

	}

	public boolean equals(Object obj) {
		System.out.println("invoking equals method");
		boolean eq = false;
		if (obj instanceof Number1) {
			Number1 n = (Number1) obj;
			if (a == n.a && b == n.b) {
				eq = true;
			}
		}
		return eq;

	}
}