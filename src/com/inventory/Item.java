package com.inventory;

public class Item {
	private String itemName;
	private double itemscostPrice;
	private double itemsellPrice;
	private int itemQuantity;
	private double valueOfItem;

	public Item(String itemName, double itemscostPrice, double itemsellPrice, int itemQuantity) {
		super();
		this.itemName = itemName;
		this.itemscostPrice = Math.round(itemscostPrice * 100.00) / 100.00;
		this.itemsellPrice = Math.round(itemsellPrice * 100.00) / 100.00;
		this.itemQuantity = itemQuantity;
		this.valueOfItem = itemQuantity * itemscostPrice;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getItemsellPrice() {
		return itemsellPrice;
	}

	public void setItemsellPrice(double itemsellPrice) {
		this.itemsellPrice = Math.round(itemsellPrice * 100.00) / 100.00;
	}

	public double getItemscostPrice() {
		return itemscostPrice;
	}

	public void setItemscostPrice(double itemscostPrice) {
		this.itemscostPrice = Math.round(itemscostPrice * 100.00) / 100.00;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public double getValueOfItem() {
		return valueOfItem;
	}

	public void setValueOfItem(double valueOfItem) {
		this.valueOfItem = itemQuantity * itemscostPrice;
	}

	/*
	 * Print and Format the Inventory report.
	 */
	public void printRow() {
		System.out.printf("%-15s %-15.2f %-15.2f %-15d %-15.2f%n", itemName, itemscostPrice, itemsellPrice,
				itemQuantity, valueOfItem);

	}

}


