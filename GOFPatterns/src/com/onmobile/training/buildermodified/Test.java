package com.onmobile.training.buildermodified;

public class Test {
	public static void main(String[] args) {
		Cook cook = new Cook();
		
		cook.setBeverageBuilder(new CoffeeBuilder());
		System.out.println(cook.constructBeverage());
	}
}
