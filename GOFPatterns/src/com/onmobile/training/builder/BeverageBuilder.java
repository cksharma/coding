package com.onmobile.training.builder;

public abstract class BeverageBuilder {
	protected HotBeverage beverage;
	
	public abstract void buildLiquid();
	public abstract void buildFlavour();
	public abstract void buildSweetner();
	
	public void createBeverage() 
	{
		beverage = new HotBeverage();
	}
	
	public HotBeverage getBeverage()
	{
		return beverage;
	}
}
