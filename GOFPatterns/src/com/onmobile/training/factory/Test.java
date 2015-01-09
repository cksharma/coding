package com.onmobile.training.factory;

public class Test {
	public static void main(String[] args) {
		Pizza piz = PizzaFactory.createPizza("veg"); //i can work with pizza object without even knowing how is Pizza class implemented.
		// the details of producing objects is hidden from the developers.
		// the client code neednot be changed even if the pizza class name (e.g. changeing the name of VegPizza class or Chicken class)is changed in the future..
		System.out.println("Description : " + piz.getDescription());
		System.out.println("Price : " +piz.getPrice());
		
	}
}
