package edu.cksharma.designpatterns.factory;

public class ChickenPizza implements Pizza {

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Chicken";
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return 300;
	}	
}
