package edu.cksharma.designpatterns.builder;

public class Test {
	public static void main(String[] args) {
		Cook cook = new Cook();
		cook.setBeverageBuilder(new TeaBuilder());
		cook.constructBeverage();
		HotBeverage beverage = cook.getBeverage();
		System.out.println(beverage);
				
		cook.setBeverageBuilder(new SugarFreeTeaBuilder());
		cook.constructBeverage();
		System.out.println(cook.getBeverage());
				
		cook.setBeverageBuilder(new CoffeeBuilder());
		cook.constructBeverage();
		System.out.println(cook.getBeverage());
	}
}
