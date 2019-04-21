package com.bridgelabz.Stock.model;

public class Stock {
	private String stockName;
	private double noOfShare;
	private double sharePrice;
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public double getNoOfShare() {
		return noOfShare;
	}
	public void setNoOfShare(double noOfShare) {
		this.noOfShare = noOfShare;
	}
	public double getSharePrice() {
		return sharePrice;
	}
	public void setSharePrice(double sharePrice) {
		this.sharePrice = sharePrice;
	}
	
}