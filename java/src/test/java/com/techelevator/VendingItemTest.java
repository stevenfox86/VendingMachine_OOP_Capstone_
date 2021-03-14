package com.techelevator;

import org.junit.*;

import junit.framework.Assert;

public class VendingItemTest {

	VendingItem vi;
	
	@Before
	public void newInstance() {
		vi = new VendingItem("J1", "TEST CHIPS", 1.95, "Chip");
	}
	
	@Test
	public void getname_test_bag_of_chips() {
		String expectedResult = "TEST CHIPS";
		String actualResult = vi.getName();
		
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void setname_test_bag_of_chips() {
		String expectedResult = "YUMMY CHIPS";
		vi.setName("YUMMY CHIPS");
		String actualResult = vi.getName();
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void getSound_of_chips() {
		String expectedResult = "\n -Crunch Crunch, Yum!";
		String actualResult = vi.getSound();
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void getPrice_should_be_195() {
		double expectedResult = 1.95;
		double actualResult = vi.getPrice();
		Assert.assertEquals(expectedResult, actualResult, 2);
	}
	
	@Test
	public void setSound_im_a_test_sound() {
		String expectedResult = "I'M A TEST SOUND";
		vi.setSound("I'M A TEST SOUND");
		String actualResult = vi.getSound();
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void set_remaining_inventory_0() {
		int expectedResult = 0;
		vi.setRemainingInventory(0);
		int actualResult = vi.getRemainingInventory();
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void get_remaining_inventory_99() {
		int expectedResult = 99;
		vi.setRemainingInventory(99);
		int actualResult = vi.getRemainingInventory();
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void get_type_should_return_chip() {
		String expectedResult = "Chip";
		String actualResult = vi.getType();
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void set_SlotLocation_should_return_z1() {
		String expectedResult = "Z1";
		vi.setSlotLocation("Z1");
		String actualResult = vi.getSlotLocation();
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void get_SlotLocation_should_return_j1() {
		String expectedResult = "J1";
		String actualResult = vi.getSlotLocation();
		Assert.assertEquals(expectedResult, actualResult);
	}
	
}
