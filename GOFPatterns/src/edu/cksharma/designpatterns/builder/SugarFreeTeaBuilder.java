package edu.cksharma.designpatterns.builder;

public class SugarFreeTeaBuilder extends BeverageBuilder {

	@Override
	public void buildLiquid() {
		// TODO Auto-generated method stub
		beverage.setFlavour("Tea Powder + Ginger");
	}

	@Override
	public void buildFlavour() {
		// TODO Auto-generated method stub
		beverage.setLiquid("Milk + Water");
	}

	@Override
	public void buildSweetner() {
		// TODO Auto-generated method stub
		beverage.setSweetener("Sugar Free");
	}	
}
