package com.techelevator;

import java.io.FileNotFoundException;
import java.util.List;

public class VendingMachine {

	public final double MIN_BALANCE = 0;
	public double balance = MIN_BALANCE;
	
	public InventoryStocker inventoryStocker; 
	public List<VendingItem> inventory;
	
	//method to add inserted money to balance
	public void setBalance (double customerMoney) throws NumberFormatException{
		
		if (customerMoney == 1 || customerMoney == 2 || customerMoney == 5 || customerMoney == 10
			|| customerMoney == 1.00 || customerMoney == 2.00 || customerMoney == 5.00 || customerMoney == 10.00 ) {
			this.balance += customerMoney; 
			PurchaseLog.logFeed(customerMoney, balance);
        } else {
        	System.out.println("Please enter 1, 2, 5, or 10 to deposit money");
        }
	}
		
		
	public VendingMachine() {
	
		inventoryStocker = new InventoryStocker();
		
		try {
			inventory = inventoryStocker.getItem();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			}	
		}
	
		public double getBalance () {
			return balance;
		}
		
		//	update balance after purchase
		public void balanceAfterPurchase(double d) {
			if (balance < d) {
				System.out.println("You have insufficient funds");	
			} else { 
				this.balance -= d;
			}
		}
		
		
		//Method to get item
		public String getItem(String itemLocation) {
			
			for(VendingItem vi : inventory) {
				if(vi.getSlotLocation().equalsIgnoreCase(itemLocation) && vi.getRemainingInventory() > 0 && balance >= vi.getPrice()) {
					vi.remainingInventory--;
					balance -= vi.getPrice();
					PurchaseLog.logGetItem(vi.getName(), vi.getSlotLocation(), vi.getPrice(), balance);
					return vi + vi.getSound();
				} else if (vi.getSlotLocation().equalsIgnoreCase(itemLocation) && balance < vi.getPrice()) {
					return "insufficient funds available";
				} else if (vi.getRemainingInventory() == 0 && vi.getSlotLocation().equalsIgnoreCase(itemLocation)) {
					return "OUT OF STOCK";
				} 
			}
			return "Invalid selection";
		}
		
		
		
		//method to count change
	    public String getChange() {
	    	double initialBalance = balance;
	    	if(balance == 0) {
	    		return "no change to give";
	    	}
			double balanceRemaining = balance;
			String change = "";
			int quarters = 0;
			int dimes = 0;
			int nickels = 0;
			double[] changeArray = {.25, .10, .05};
			for (int i = 0; i < changeArray.length; i++) {
				while(balanceRemaining >= changeArray[i]) {
					if(changeArray[i] == .25) {
						quarters++;
						balanceRemaining -= .25;
					} else if(changeArray[i] == .10) {
						dimes++;
						balanceRemaining -= .10;
					} else if(changeArray[i] == .05) {
						nickels++;
						balanceRemaining -= .05;
					} 
				}
				change = quarters + " quarter(s) " + dimes + " dime(s) " + nickels + " nickle(s)";
				this.balance = 0;
			}
			PurchaseLog.logGetChange(initialBalance, balance);
			return change;
		}
	}

