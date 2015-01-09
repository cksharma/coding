package com.onmobile.training.builder;

public class Cook {
	private BeverageBuilder beverageBuilder;
	
	public void constructBeverage()
	{
		beverageBuilder.createBeverage();
		beverageBuilder.buildLiquid();
		beverageBuilder.buildFlavour();
		beverageBuilder.buildSweetner();
	}

	public void setBeverageBuilder(BeverageBuilder beverageBuilder) {
		this.beverageBuilder = beverageBuilder;
	}
	
	public HotBeverage getBeverage()
	{
		return beverageBuilder.getBeverage();
	}
}
