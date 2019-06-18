package com.bridgelabz.stockusinglinkedlist.implementation;

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

import com.bridgelabz.Stock.model.Stock;
import com.bridgelabz.stockusinglinkedlist.manager.StockManager;
import com.bridgelabz.stockusinglinkedlist.model.StockModel;
import com.bridgelabz.util.CustomLinkedList;
import com.bridgelabz.util.Util;
import com.google.gson.Gson;

public class Implementation implements StockManager {
	JSONArray jsonArray;
	StockModel shares = new StockModel();
	List<StockModel> list = new ArrayList<>();
	CustomLinkedList<StockModel> linkedList = new CustomLinkedList<>();
	JSONObject jobject = new JSONObject();

	@Override
	public void fileRead() {
		
		JSONParser parser = new JSONParser();
		{
			try {
				jsonArray = (JSONArray) parser.parse(new FileReader(
						"D:\\javaproject\\Object Oriented Programs\\src\\com\\bridgelabz\\stockusinglinkedlist\\model\\Stock.json"));
				System.out.println("====>>" + jsonArray);
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
			for (Object obj : jsonArray) {
				 StockModel comShare = new StockModel();
				jobject = (JSONObject) obj;
				String name = (String) jobject.get("name");
			      Long noOfShare = (Long) jobject.get("share number"); comShare.setComapanyName(name);
			  comShare.setNoOfShare(noOfShare);
			  linkedList.add(comShare);
			}
		}
	}

	@Override
	public void add() {
		System.out.println("linked  list before adding:");
		linkedList.printList();
		StockModel share = new StockModel();
		System.out.println("enter company name to add");
		String name = Util.getString();
		System.out.println("enter the number of share");
		Long noOfShare = Util.getLong();
		String name1 = share.setComapanyName(name);
		Long noshare = share.setNoOfShare(noOfShare);
		linkedList.add(share);
		System.out.println("linked  list after adding:");
		linkedList.printList();
		System.out.println(linkedList.size());
	}
	
	@Override
	public void remove(String name) {

		System.out.println("Linked List" + new Gson().toJson(linkedList));

		for (StockModel share : linkedList) {
			if (share != null && share.getComapanyName().equals(name)) {
				linkedList.remove(share);
			}

		}
		System.out.println("removed");
		System.out.println("linked  list after removing:");
		linkedList.printList();
	}

	@Override
	public void writeFile() {
		Gson gson = new Gson();
		System.out.println("list to be written into file");
		linkedList.printList();
		String g = gson.toJson(linkedList);
		System.out.println("writing into file");
		System.out.println("content" + g);

		try {
			FileWriter file = new FileWriter("D:\\javaproject\\Object Oriented Programs\\src\\com\\bridgelabz\\stockusinglinkedlist\\model\\Stock.json");
			file.write(g);
			file.flush();
			System.out.println("written into file");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}