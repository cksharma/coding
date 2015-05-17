package com.onmobile.training;

import java.util.*;

public class Sales 
{
	int salesId;
	Date salesTime;
	int item;
	int quantitySold;
	
	public int getSalesId() {
		return salesId;
	}
	public void setSalesId(int salesId) {
		this.salesId = salesId;
	}
	public Date getSalesTime() {
		return salesTime;
	}
	public void setSalesTime(Date salesTime) {
		this.salesTime = salesTime;
	}
	public int getItem() {
		return item;
	}
	public void setItem(int item) {
		this.item = item;
	}
	public int getQuantitySold() {
		return quantitySold;
	}
	public void setQuantitySold(int quantitySold) {
		this.quantitySold = quantitySold;
	}
	
	public Sales(int salesId, Date salesTime, int item, int quantitySold) {
		super();
		this.salesId = salesId;
		this.salesTime = salesTime;
		this.item = item;
		this.quantitySold = quantitySold;
	}
	
	public Sales() 
	{
		super();
	}
	@Override
	public String toString() {
		return "Sales [salesId=" + salesId + ", salesTime=" + salesTime
				+ ", item=" + item + ", quantitySold=" + quantitySold + "]";
	}
	
	
}
