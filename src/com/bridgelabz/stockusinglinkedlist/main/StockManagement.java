package com.bridgelabz.stockusinglinkedlist.main;

import com.bridgelabz.stockusinglinkedlist.implementation.Implementation;
import com.bridgelabz.stockusinglinkedlist.manager.StockManager;
import com.bridgelabz.util.Util;

public class StockManagement {

	public static void main(String[] args) {
		
		StockManager ref=new Implementation();
		
		ref.fileRead();
	    ref.add();
		System.out.println("enter the name you want to delet");
		String name=Util.getString();
		ref.remove(name);
		ref.writeFile();
	}
}
