package com.bridgelabz.commercialdataprocessing.manager;

public interface StockAccountService {
	
	public void createStockAccount();

	public void buy(String stockCompany, double sharePrice);

	public void sell(String stockCompany, double sharePrice);

	public double valueOf();

	public void save();

	public void printReport();

}