package com.bridgelabz.inventorymanagement.model;

import java.util.List;

public class InventoryManagement {

	private List<Inventory> rice;
	private List<Inventory> wheat;
	private List<Inventory> pulses;

	public InventoryManagement() {
	}

	public InventoryManagement(List<Inventory> rice, List<Inventory> wheat, List<Inventory> pulses) {
		this.rice = rice;
		this.wheat = wheat;
		this.pulses = pulses;
	}

	public List<Inventory> getRice() {
		return rice;
	}

	public void setRice(List<Inventory> rice) {
		this.rice = rice;
	}

	public List<Inventory> getWheat() {
		return wheat;
	}

	public void setWheat(List<Inventory> wheat) {
		this.wheat = wheat;
	}

	public List<Inventory> getPulses() {
		return pulses;
	}

	public void setPulses(List<Inventory> pulses) {
		this.pulses = pulses;
	}
}
