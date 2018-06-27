package com.inventory;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class InventoryController {
	// Define Command Variables
	private static final String createItem = "create";
	private static final String deleteItem = "delete";
	private static final String updateBuyItem = "updateBuy";
	private static final String updateSellItem = "updateSell";
	private static final String reportInventory = "report";

	
	private static final String updateSellPriceOfItem = "updateSellPrice";
	static {
		System.gc();
	}

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		try {
			Scanner scanner = new Scanner(System.in);
			String lineText = null;
			while (true) {
				System.out.print("Enter command,'q' to quit :");
				// Read User input value
				lineText = scanner.nextLine();
				if ("q".equalsIgnoreCase(lineText)) {
					System.out.println("Exit!");
					break;
				}
				String[] commands = lineText.split(" ");
				String command = commands[0];
				if (createItem.equalsIgnoreCase(command)) {
					Inventory.create(commands[1], Double.valueOf(commands[2]), Double.valueOf(commands[3]));
				} else if (deleteItem.equalsIgnoreCase(command)) {
					Inventory.delete(commands[1]);
				} else if (updateBuyItem.equalsIgnoreCase(command)) {
					Inventory.updateBuy(commands[1], Integer.valueOf(commands[2]));
				} else if (updateSellItem.equalsIgnoreCase(command)) {
					Inventory.updateSell(commands[1], Integer.valueOf(commands[2]));
				} else if (updateSellPriceOfItem.equalsIgnoreCase(command)) {
					Inventory.updateSellprice(commands[1], Double.valueOf(commands[2]));
				} else if (reportInventory.equalsIgnoreCase(command)) {
					Inventory.report();
				} else {
					System.out.println("Invalid Command ");
				}
			}
			scanner.close();

		} catch (FileNotFoundException ex) {
			System.err.println(ex.getMessage());
		} catch (IOException ex) {
			System.err.println(ex.getMessage());
		} catch (ArrayIndexOutOfBoundsException ex1) {
			System.out.println("Invalid Arguments Passed, Truncating the Process");
		} catch (Exception e) {

			System.out.println(e.getMessage() + ", Truncating the Process");
		}

	}

}
