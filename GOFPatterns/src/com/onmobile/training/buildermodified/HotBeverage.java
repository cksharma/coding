package com.onmobile.training.buildermodified;

public class HotBeverage {
	
	private String liquid;
	private String flavour;
	private String sweetener;
	
	public void setLiquid(String liquid) {
		this.liquid = liquid;
	}
	public void setFlavour(String flavour) {
		this.flavour = flavour;
	}
	public void setSweetener(String sweetener) {
		this.sweetener = sweetener;
	}
	@Override
	public String toString() {
		return "HotBeverage [liquid=" + liquid + ", flavour=" + flavour
				+ ", sweetener=" + sweetener + "]";
	}
}
