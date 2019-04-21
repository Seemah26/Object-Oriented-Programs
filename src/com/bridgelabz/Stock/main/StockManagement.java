package com.bridgelabz.Stock.main;

import com.bridgelabz.Stock.implementation.StockImplementation;
import com.bridgelabz.Stock.manager.StockManager;
import com.bridgelabz.util.Util;

public class StockManagement {

	public static void main(String[] args) {

		StockManager stock = new StockImplementation();

		stock.readFile();
		System.out.println("enter stockName");
		String stockName = Util.getString();
		System.out.println("enter noOfShare");
		int noOfShare = Util.getInt();
		System.out.println("enter sharePrice");
		double sharePrice = Util.getDouble();
		stock.addStock(stockName, noOfShare, sharePrice);
		stock.calculateStock();
		stock.writeFile();
		stock.calculateTotalStock();
	}
}
