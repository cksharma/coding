package edu.cksharma.designpatterns.buildermodified;

public class Cook {
	private BeverageBuilder beverageBuilder;
	
	public HotBeverage constructBeverage()
	{
		beverageBuilder = beverageBuilder.createBeverage().buildLiquid().buildFlavour().buildSweetner();
		return beverageBuilder.getBeverage();
	}

	public void setBeverageBuilder(BeverageBuilder beverageBuilder) {
		this.beverageBuilder = beverageBuilder;
	}
	
}
