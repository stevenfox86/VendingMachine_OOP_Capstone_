package com.techelevator;

import java.text.DecimalFormat;

public class VendingItem {
	DecimalFormat format = new DecimalFormat("0.00");
	private String slotLocation;
	private String name;
	private double price;
	private String type;
	private final int MAX_INVENTORY =5;
	protected int remainingInventory = MAX_INVENTORY;
	private String sound = "";
	
	
	VendingItem(String slotLocation, String name, double price, String type){
	    this.slotLocation = slotLocation;
	    this.name = name;
	    this.price = Double.parseDouble(format.format(price));
	    this.type = type;
	    this.remainingInventory = MAX_INVENTORY;
	    this.sound = "";
	    
	    if(this.type.equals("Chip")){
			this.sound = "\n -Crunch Crunch, Yum!";
		} 
		  else if(this.type.equals("Candy")){
			this.sound = "\n -Munch Munch, Yum!";
		} 
		  else if(this.type.equals("Drink")){
			this.sound = "\n -Glug Glug, Yum!";
		} 
		  else if(this.type.equals("Gum")){
			this.sound = "\n -Chew Chew, Yum!";
		}
	}
	
	public VendingItem(){};
	public String getSlotLocation() {
	    return slotLocation;
	}
	public void setSlotLocation(String slotLocation){
	    this.slotLocation = slotLocation;
	}
	public String getName() {
	    return name;
	}
	public void setName(String itemName){
	    this.name = itemName;
	}
	public double getPrice() {
	    return price;
	}
	public void setType(String itemType){
	    this.type = itemType;
	}
	public String getType() {
	    return type;
	}
	public String getSound() {
		return this.sound;
	}
	public void setSound(String sound) {
		this.sound = sound;
	}
	public void setRemainingInventory(int remainingInventory){
	    this.remainingInventory = remainingInventory;
	}
	public int getRemainingInventory() {
	    return remainingInventory;
	}
	
	@Override
	public String toString() {
		return slotLocation + " " + name + " $" + format.format(price) + " quantity remaining: " + remainingInventory;
	}
	
	
}
