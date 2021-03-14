package com.techelevator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PurchaseLog {
	
	// method to convert local date time to 01/01/2016 12:00:00 PM 
	static Date dNow = new Date( );
    static SimpleDateFormat ft = 
    new SimpleDateFormat ("MM/dd/yyyy hh:mm:ss a");
	
	public static void log(String message) {
		
		File log = new File("Log.txt");
		
		try (PrintWriter logWriter = new PrintWriter(new FileOutputStream(log, true))){
			if(!log.exists()) {log.createNewFile();}
			logWriter.println(message);
			logWriter.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	// log for depositing money
	public static void logFeed(Double amountAdded, Double currentBalance) {	
		log(ft.format(dNow) + " FEED MONEY: $" + String.format("%.2f", amountAdded) + " $" + String.format("%.2f", currentBalance));
	}
	
	// log for purchasing item
	public static void logGetItem(String itemName, String itemLocation, Double cost, Double currentBalance) {	
		log(ft.format(dNow) + " " + itemName + " " + itemLocation + " $" + String.format("%.2f", cost) + " $" + String.format("%.2f", currentBalance));
	}

	// log for getting change
	public static void logGetChange(Double currentBalance, Double balanceRemaining) {
		log(ft.format(dNow) + " GIVE CHANGE: $" + String.format("%.2f", currentBalance) + " $" + String.format("%.2f", balanceRemaining));
	}

}
