package com.onmobile.training.buildermodified;

public abstract class BeverageBuilder {
	protected HotBeverage beverage;
	
	public abstract BeverageBuilder buildLiquid();
	public abstract BeverageBuilder buildFlavour();
	public abstract BeverageBuilder buildSweetner();
	
	public BeverageBuilder createBeverage() 
	{
		beverage = new HotBeverage();
		return this;
	}
	
	public HotBeverage getBeverage()
	{
		return beverage;
	}
}
