package com.bridgelabz.inventory.manager;

public interface InventoryManager {

	public void fileRead();

	public void writeFile();

	public void add(String name, double weight, double price);

	public void remove(String name);

	public void calculateInventory();

}