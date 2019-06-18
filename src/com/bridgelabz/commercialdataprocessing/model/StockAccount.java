package com.bridgelabz.commercialdataprocessing.model;
public class StockAccount {
	private String stockCompany;
	private double noOfShares;
	private double sharePrice;
	private String currentDateTime;

	public String getStockCompany() {
		return stockCompany;
	}

	public void setStockCompany(String stockCompany) {
		this.stockCompany = stockCompany;
	}

	public double getNoOfShares() {
		return noOfShares;
	}

	public void setNoOfShares(double noOfShares) {
		this.noOfShares = noOfShares;
	}

	public double getSharePrice() {
		return sharePrice;
	}

	public void setSharePrice(double sharePrice) {
		this.sharePrice = sharePrice;
	}

	public String getCurrentDateTime() {
		return currentDateTime;
	}

	public void setCurrentDateTime(String currentDateTime) {
		this.currentDateTime = currentDateTime;
	}

	@Override
	public String toString() {
		return "stockCompany: " + stockCompany + "\n " + "noOfShares: " + noOfShares + "\n " + "sharePrice: "
				+ sharePrice + "\n " + "DateTime: " + currentDateTime;
	}
}