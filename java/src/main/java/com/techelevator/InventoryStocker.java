package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventoryStocker {

	public List<VendingItem> getItem() throws FileNotFoundException{
		//DecimalFormat format = new DecimalFormat("0.00"); 
		ArrayList<VendingItem> vendingItems = new ArrayList<>();
	      File myObj = new File("vendingMachine.csv");
	      Scanner myReader = new Scanner(myObj);
	   
	      while (myReader.hasNextLine()) {
	    	
	        String line = myReader.nextLine();        
	        String[] itemProperties = line.split("\\|");
	        String itemLocation = itemProperties[0];
	        String itemDescription = itemProperties[1];
	        double currentPrice = Double.parseDouble(itemProperties[2]);
	        String itemType = itemProperties[3];
	        
	        /// PARSE ITEMS PROPS        
	        vendingItems.add(new VendingItem(itemLocation, itemDescription, currentPrice, itemType ));     
	      }
	      
	      myReader.close();
	      return vendingItems;
	    }
}

