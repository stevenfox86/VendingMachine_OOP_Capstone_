package com.techelevator;

import com.techelevator.view.Menu;

import java.text.DecimalFormat;
import java.util.Scanner;

public class VendingMachineCLI {
	
	//System.out.println("\nCurrent Money Provided: $" + format.format(vm.getBalance()));

	DecimalFormat format = new DecimalFormat("0.00"); 
	Scanner input = new Scanner(System.in);
	VendingMachine vm = new VendingMachine();

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION };
	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}
	
	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				for(VendingItem vi : vm.inventory) {
					System.out.println(vi);
				}
				
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				System.out.println("\nCurrent Money Provided: $" + format.format(vm.getBalance()));
				
				choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
				
				if (choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
					System.out.print("How much money would you like to insert: ");
					double balance = 0;
					try {
					balance = Double.parseDouble(input.nextLine());
				 }
		        catch (NumberFormatException e) {
		            System.out.println("Invalid currency!");
		        }
					vm.setBalance(balance);
				} else if (choice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
					// do purchase
					
					for(VendingItem vi : vm.inventory) {
						System.out.println(vi);
					}
					
					System.out.print("\nPlease enter a code to select an item: ");
					String selectedSlot = input.nextLine();
					System.out.println(vm.getItem(selectedSlot));
					
				} else if (choice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
					System.out.println(vm.getChange());
					System.out.println("Have a nice day!");
					System.exit(1);
				} 
				
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.out.println(vm.getChange());
				System.out.println("Have a nice day!");
				System.exit(1);
			}
		}
	}

	public static void main(String[] args) {
		
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
