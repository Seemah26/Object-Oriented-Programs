package com.bridgelabz.inventorymanagement.main;

import com.bridgelabz.inventorymanagement.implementation.InventoryManagementImpelementation;
import com.bridgelabz.inventorymanagement.manager.InventoryManager;

public class InventoryManagement {

	
	public static void main(String[] args)
	{
		InventoryManager inventory = new InventoryManagementImpelementation();
		inventory.calculateInventoryPrice();
	}
}
