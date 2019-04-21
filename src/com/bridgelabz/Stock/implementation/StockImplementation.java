package com.bridgelabz.Stock.implementation;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.Stock.manager.StockManager;
import com.bridgelabz.Stock.model.Stock;
import com.google.gson.Gson;

public class StockImplementation implements StockManager {
	
	
	JSONArray jsonArray;
	List<Stock> stocks = new ArrayList<>();

	JSONObject jobject = new JSONObject();
	@Override
	public void readFile() {
		// TODO Auto-generated method stub
		JSONParser parser = new JSONParser();
		{
			
				try {
					jsonArray = (JSONArray) parser.parse(new FileReader("D:\\javaproject\\Object Oriented Programs\\src\\com\\bridgelabz\\Stock\\model\\Stock.json"));
					System.out.println("====>>"+jsonArray);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				for (Object obj : jsonArray) {
					Stock stockk = new Stock();

					jobject = (JSONObject) obj;
					String stockname = (String) jobject.get("stockName");
					double noofshare = ((Double) jobject.get("noOfShare")).doubleValue();
					double shareprice = ((Double) jobject.get("sharePrice")).doubleValue();
					stockk.setStockName(stockname);   //setWeight(weight);
					stockk.setNoOfShare(noofshare);
					// System.out.println(inventory.getName());

					// System.out.println(inventory.getWeight());
					stockk.setSharePrice(shareprice);
					// System.out.println(inventory.getPrice());
					stocks.add(stockk);

					//System.out.println(stockk.toString());
				
			} 
	}
	}
	
	@Override
	public void addStock(String stockName, double noOfShare, double sharePrice) {
		// TODO Auto-generated method stub
		Stock stoc = new Stock();
		stoc.setStockName(stockName);
		stoc.setNoOfShare(noOfShare);
		stoc.setSharePrice(sharePrice);
		stocks.add(stoc);
		//stocks.forEach(inventory1 -> System.out.println(inventory1.toString()));
	}

	@Override
	public void calculateStock() {
		// TODO Auto-generated method stub
		stocks.forEach(stock -> System.out.println(
				"Total price of " + stock.getStockName() + " is " +(stock.getNoOfShare()*stock.getSharePrice())));
	
}
	

	

	@Override
	public void writeFile() {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		String json = gson.toJson(stocks);
		

		try(FileWriter file = new FileWriter("D:\\javaproject\\Object Oriented Programs\\src\\com\\bridgelabz\\Stock\\model\\Stock.json")){
			file.write(json);
			System.out.println("SuccessFully copied to JSON  Object to File......");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("\n JSON Object " + json);
	}

	@Override
	public void calculateTotalStock() {
		// TODO Auto-generated method stub
		double sum = 0;
		for (Stock stock : stocks)
		{
			sum = sum + (stock.getSharePrice() * stock.getNoOfShare());
		}
		System.out.println("Total profit of shareholder=" + sum);
		
		
		
		}
	}