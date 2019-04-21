package com.bridgelabz.Stock.manager;
public interface StockManager {

	public void addStock(String stockName, double noOfShare, double sharePrice);

	public void calculateStock();

	public void readFile();

	public void writeFile();
	
	public void calculateTotalStock();
}