package com.bridgelabz.inventorymanagement.model;

import org.json.simple.JSONObject;

public class Inventory {
	private String name;
	private double weight;
	private double price;

	public Inventory() {
	}

	// Converting JsonObject to Inventory
	public Inventory(JSONObject object) {
		this.name = (String) object.get("name");
		this.weight = (double) object.get("weight");
		this.price = (double) object.get("price");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getCalculatedValue() {
		return (price * weight);
	}

	@Override
	public String toString() {
		return "name: " + name + "\n " + "weight: " + weight + "\n " + "price: " + price + "";
	}
}