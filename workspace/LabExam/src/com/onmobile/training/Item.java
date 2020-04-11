package com.onmobile.training;

public class Item 
{
	int itemId;
	String itemName;
	double price;
	
	int quantityAvailable;
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantityAvailable() {
		return quantityAvailable;
	}
	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}
	
	public Item(int itemId, String itemName, double price, int quantityAvailable) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.price = price;
		this.quantityAvailable = quantityAvailable;
	}
	public Item() {
		super();
	
	}
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", price="
				+ price + ", quantityAvailable=" + quantityAvailable + "]";
	}
	
}
