package com.bridgelabz.commercialdataprocessing.implementation;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.bridgelabz.commercialdataprocessing.manager.StockAccountService;
import com.bridgelabz.commercialdataprocessing.model.StockAccount;
import com.bridgelabz.util.Util;
import com.bridgelabz.util.Util.FileOperation;
import com.google.gson.Gson;

public class StockAccountServiceImpl implements StockAccountService {
	List<StockAccount> listOfStocks = new ArrayList<>();
	StockAccount stockObject = new StockAccount();
    JSONArray jsonArray;
	public void createStockAccount() {
		JSONParser parser = new JSONParser();

		try {
			//String path="C:\\Users\\LENOVO\\eclipse-workspace\\Bridgelabz\\src\\com\\bridgelabs\\stockaccount\\model\\StockAccount.json";
			Object object = parser.parse(new FileReader("D:\\javaproject\\Object Oriented Programs\\src\\com\\bridgelabz\\commercialdataprocessing\\model\\StockApp.json"));
		JSONObject jsonObject = (JSONObject) object;
			JSONArray jsonArray = (JSONArray) jsonObject.get("ShareHolders");
			
			for (Object arrayObject : jsonArray) {
				StockAccount parameters = new StockAccount();
				String stockCompany = (String) ((JSONObject) arrayObject).get("stockCompany");
				double numberOfShares = (double) ((JSONObject) arrayObject).get("noOfShares");
				double sharePrice = (double) ((JSONObject) arrayObject).get("sharePrice");
				String date = (String) ((JSONObject) arrayObject).get("currentDateTime");

				parameters.setStockCompany(stockCompany);

				parameters.setNoOfShares(numberOfShares);
				parameters.setSharePrice(sharePrice);
				parameters.setCurrentDateTime(date);
				listOfStocks.add(parameters);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public double valueOf() {
		listOfStocks.forEach(stock -> {
			System.out.println("Gain of stocks on " + stock.getStockCompany() + " is "
					+ (stock.getNoOfShares() * stock.getSharePrice()));
		});
		return 0;
	}

	public void buy(String stockCompany, double sharePrice) {

		stockObject.setStockCompany(stockCompany);
		stockObject.setSharePrice(sharePrice);

		LocalDateTime currentDateTime = LocalDateTime.now();
		stockObject.setCurrentDateTime(currentDateTime.toString());

		System.out.println("You bought the stock" + stockObject.getStockCompany() + "for" + " " + stockObject.getSharePrice());
		System.out.println("Enter the number of shares ");
		double noOfShares = Util.getDouble();
		stockObject.setNoOfShares(noOfShares);
		listOfStocks.add(stockObject);
		listOfStocks.forEach(stock -> System.out.println(stock.toString()));
	}

	@Override
	public void sell(String stockCompany, double sharePrice) {

		stockObject.setStockCompany(stockCompany);
		stockObject.setSharePrice(sharePrice);

		LocalDateTime currentDateTime = LocalDateTime.now();
		stockObject.setCurrentDateTime(currentDateTime.toString());
		System.out.println("You are selling the stock" + stockObject.getStockCompany() + "for" + " " + stockObject.getSharePrice());
		listOfStocks.removeIf(inventory -> inventory.getStockCompany().equals(stockCompany));
		System.out.println("Element successfully removed");
		listOfStocks.forEach(stock -> System.out.println(stock.toString()));
	}

	@Override
	public void save() {
		Gson gson = new Gson();
		String json = gson.toJson(listOfStocks);
		try {
			FileWriter file = new FileWriter(
					"C:\\Users\\LENOVO\\eclipse-workspace\\Bridgelabz\\src\\com\\bridgelabs\\stockaccount\\model\\StockAccount.json");
			file.write("{\"ShareHolders\":" + json + "}");
			file.flush();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void printReport() {
		listOfStocks.forEach(stock -> System.out.println(stock.toString()));
	}
}