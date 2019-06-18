package com.bridgelabz.commercialdataprocessing.main;

import com.bridgelabz.commercialdataprocessing.implementation.StockAccountServiceImpl;
import com.bridgelabz.commercialdataprocessing.manager.StockAccountService;
import com.bridgelabz.util.Util;

public class StockAccountApp {

	public static void main(String[] args) {

		StockAccountService stockImpl = new StockAccountServiceImpl();
		{

            stockImpl.createStockAccount();
            while (true) {
    			System.out.println("1.Buy\n2.Sell\n3.calculate each share value\n4.Display\n");
		    System.out.println("Input choice");
			int input = Util.getInt();
			switch (input) {
			
            case 1:
           
            	System.out.println("Choose a stock Company you want to buy:");
    			String StockCompany=Util.getString();
    			System.out.println("Enter the amount you are buying for:");
    			double sharePrice= Util.getDouble();
    			stockImpl.buy(StockCompany,sharePrice);
    			stockImpl.save();
    			break;
         
    		case 2:
    			System.out.println("Choose a stock Company you want to sell");
    			String SellCompany= Util.getString();
    			System.out.println("Enter the amount you are selling for:");
    			double sharePrice1= Util.getDouble();
    			stockImpl.sell(SellCompany,sharePrice1);
    			stockImpl.save();
    			break;
    	
       	  case 3:
                stockImpl.valueOf();
                break;
       	  case 4:
       		    stockImpl.printReport();
       		    break;
       	 
       	  default:
       		  System.out.println("Please enter valid number");
			}

			
            }	
	
             
			}
	

	}

}