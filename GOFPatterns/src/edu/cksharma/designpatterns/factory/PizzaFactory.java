package edu.cksharma.designpatterns.factory;

public class PizzaFactory {
	public static Pizza createPizza(String type)
	{
		Pizza piz = null;
		if(type.equals("veg")) {
			piz = new VegPizza();
		}
		else if(type.equals("chick")) {
			piz = new ChickenPizza();
		}
		return piz;
	}
}
