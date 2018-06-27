package com.inventory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Inventory {
	static Map<String, Item> inverntoryList = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
	private static double profit = 0;

	/*
	 * creates a new item in the inventory with the given cost price and selling
	 * price
	 */
	public static void create(String name, Double costPrice, Double sellPrice) {
		if (!inverntoryList.containsKey(name)) {
			Item createItem = new Item(name, costPrice, sellPrice, 0);
			inverntoryList.put(name, createItem);
		} else {
			inverntoryList.put(name, new Item(name, costPrice, sellPrice, inverntoryList.get(name).getItemQuantity()));

		}
	}

	/*
	 * remove the item from the inventory
	 */
	public static void delete(String name) throws Exception {
		if (inverntoryList.containsKey(name)) {
			Item availableItem = inverntoryList.get(name);
			profit = profit - (availableItem.getItemscostPrice() * availableItem.getItemQuantity());
			inverntoryList.remove(name);
		} else {
			throw new Exception("Invalid Remove Command : " + name + " Not Found");
		}

	}

	/*
	 * increase the quantity of the mentioned item
	 */
	public static void updateBuy(String name, int quantity) throws Exception {
		if (inverntoryList.containsKey(name)) {
			Item availableItem = inverntoryList.get(name);
			Item UpdateItem = new Item(name, availableItem.getItemscostPrice(), availableItem.getItemsellPrice(),
					availableItem.getItemQuantity() + quantity);
			inverntoryList.put(name, UpdateItem);
		} else {
			throw new Exception("Invalid Update Command : " + name + " Not Found");
		}
	}

	/*
	 * deduct the quantity of the mentioned item
	 */
	public static void updateSell(String name, int quantity) throws Exception {
		if (inverntoryList.containsKey(name)) {
			Item availableItem = inverntoryList.get(name);
			if (availableItem.getItemQuantity() < quantity) {
				throw new Exception("Invalid Update Command  : Insufficient Quantity");
			}
			profit += quantity * (availableItem.getItemsellPrice() - availableItem.getItemscostPrice());
			Item UpdateItem = new Item(name, availableItem.getItemscostPrice(), availableItem.getItemsellPrice(),
					availableItem.getItemQuantity() - quantity);
			inverntoryList.put(name, UpdateItem);
		} else {
			throw new Exception("Invalid Update Command : " + name + " Not Found");
		}
	}

	public static void updateSellprice(String name, double sellPrice) throws Exception {
		if (inverntoryList.containsKey(name)) {
			Item availableItem = inverntoryList.get(name);
			Item UpdateItem = new Item(name, availableItem.getItemscostPrice(), sellPrice,
					availableItem.getItemQuantity());
			inverntoryList.put(name, UpdateItem);
		} else {
			throw new Exception("Invalid Update Command : " + name + " Not Found");
		}
	}

	/*
	 * print the current inventory details in the specified format sorted by
	 * alphabetical order. Apart from printing the inventory it will to print
	 * the profits since last report generation. profit is calculated by: Sum *
	 * (sellingPrice-costPrice) of the sold items multiplied by no. of items
	 * sold- costPrice of the deleted items
	 */
	public static void report() {
		double totalValue = 0.00;

		String response = "";
		printHeader();
		List<String> itemNames = new ArrayList<>(inverntoryList.keySet());
		Collections.sort(itemNames);
		for (String itemName : itemNames) {
			totalValue += inverntoryList.get(itemName).getValueOfItem();

			inverntoryList.get(itemName).printRow();
		}
		System.out.println("---------------------------------------------------------------------------");
		response += String.format("%-65s", "Total value") + String.format("%.2f%n", totalValue);
		response += String.format("%-65s", "Profit since previous report ") + String.format("%.2f%n", profit);
		profit = 0;
		System.out.println(response);
	}

	/*
	 * Print the Inventory table Header
	 */
	private static void printHeader() {
		System.out.printf(String.format("%50s%n%n", "INVENTORY REPORT"));
		System.out.printf("%-15s %-15s %-15s %-15s %-15s%n", "Item Name", "Bought At", "Sold At", "AvailableQty",
				"Value");
		System.out.printf("%-15s %-15s %-15s %-15s %-15s%n", "---------", "---------", "-------", "------------",
				"-----");
	}

}


