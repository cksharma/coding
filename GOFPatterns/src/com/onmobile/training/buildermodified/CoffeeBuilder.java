package com.onmobile.training.buildermodified;

public class CoffeeBuilder extends BeverageBuilder {

	@Override
	public BeverageBuilder buildLiquid() {
		// TODO Auto-generated method stub
		beverage.setFlavour("Coffee Powder ");
		return this;
	}

	@Override
	public BeverageBuilder buildFlavour() {
		// TODO Auto-generated method stub
		beverage.setLiquid("Milk ");
		return this;
	}

	@Override
	public BeverageBuilder buildSweetner() {
		// TODO Auto-generated method stub
		beverage.setSweetener("Sugar");
		return this;
	}	
}
