package edu.cksharma.designpatterns.factory;

public class VegPizza implements Pizza{

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Veg";
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return 200;
	}	
}
