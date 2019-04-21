package com.bridgelabz.inventory.main;

import com.bridgelabz.inventory.implementation.InventoryImplementation;
import com.bridgelabz.inventory.manager.InventoryManager;
import com.bridgelabz.util.Util;

public class InventoryManagment {
	public static void main(String[] args) {

		InventoryManager inventory = new InventoryImplementation();
		{

			inventory.fileRead();

			System.out.println("enter name");
			String name = Util.getString();

			System.out.println("enter weight");
			int weight = Util.getInt();

			System.out.println("enter price");
			double price = Util.getDouble();

			inventory.add(name, weight, price);

			inventory.calculateInventory();

			inventory.writeFile();

			inventory.remove(name);
		}

	}
}