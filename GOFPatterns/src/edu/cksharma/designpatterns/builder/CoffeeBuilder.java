package edu.cksharma.designpatterns.builder;

public class CoffeeBuilder extends BeverageBuilder {

	@Override
	public void buildLiquid() {
		// TODO Auto-generated method stub
		beverage.setFlavour("Coffee Powder ");
	}

	@Override
	public void buildFlavour() {
		// TODO Auto-generated method stub
		beverage.setLiquid("Milk ");
	}

	@Override
	public void buildSweetner() {
		// TODO Auto-generated method stub
		beverage.setSweetener("Sugar");
	}	
}
