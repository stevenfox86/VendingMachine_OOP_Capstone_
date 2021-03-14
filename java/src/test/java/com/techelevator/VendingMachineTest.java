package com.techelevator;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class VendingMachineTest {

	VendingMachine t;
	
	@Before
	public void newInstance() {
		t = new VendingMachine();
	}
	
	@Test
	public void test_money_inserted_100() {
		double expectedResult = 1;
		t.setBalance(1);
		double actualResult = t.getBalance();
		
		Assert.assertEquals(expectedResult, actualResult, 2);
	}
	
	@Test
	public void test_money_inserted_300() {
		double expectedResult = 0;
		t.setBalance(3);
		double actualResult = t.getBalance();
		
		Assert.assertEquals(expectedResult, actualResult, 2);
	}
	
	@Test
	public void test_update_balance_5_with_purcahse_1() {
		double expectedResult = 4;
		t.setBalance(5);
		t.balanceAfterPurchase(1);
		double actualResult = t.getBalance();
		
		Assert.assertEquals(expectedResult, actualResult, 2);
	}
	
	@Test
	public void test_update_balance_insufficient_funds() {
		double expectedResult = 1;
		t.setBalance(1);
		t.balanceAfterPurchase(1.05);
		double actualResult = t.getBalance();
		
		Assert.assertEquals(expectedResult, actualResult, 2);
	}
	
	
	@Test
	public void test_balance_040() {
		String expectedResult = "1 quarter(s) 1 dime(s) 1 nickle(s)";
		t.balance = 0.40;
		String actualResult = t.getChange();
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void test_balance_4() {
		String expectedResult = "16 quarter(s) 0 dime(s) 0 nickle(s)";
		t.balance = 4;
		String actualResult = t.getChange();
		
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void test_balance_0() {
		String expectedResult = "no change to give";
		String actualResult = t.getChange();
		
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void test_balance_5() {
		String expectedResult = "0 quarter(s) 0 dime(s) 1 nickle(s)";
		t.balance = 0.05;
		String actualResult = t.getChange();
		
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void get_item_a1() {
		String expectedResult = "A1 Potato Crisps $3.05 quantity remaining: 4\n -Crunch Crunch, Yum!";
		t.balance = 4;
		String actualResult = t.getItem("a1");
		
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void get_item_b1() {
		String expectedResult = "B1 Moonpie $1.80 quantity remaining: 4\n -Munch Munch, Yum!";
		t.balance = 4;
		String actualResult = t.getItem("b1");
		
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void get_item_c1() {
		String expectedResult = "C1 Cola $1.25 quantity remaining: 4\n -Glug Glug, Yum!";
		t.balance = 4;
		String actualResult = t.getItem("c1");
		
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void get_item_d1() {
		String expectedResult = "D1 U-Chews $0.85 quantity remaining: 4\n -Chew Chew, Yum!";
		t.balance = 4;
		String actualResult = t.getItem("d1");
		
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void get_item_invalid_item() {
		String expectedResult = "Invalid selection";
		t.balance = 4;
		String actualResult = t.getItem("z1");
		
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void get_item_out_of_stock() {
		String expectedResult = "OUT OF STOCK";
		t.balance = 20;
		t.getItem("A1");
		t.getItem("A1");
		t.getItem("A1");
		t.getItem("A1");
		t.getItem("A1");
		String actualResult = t.getItem("a1");
		
		Assert.assertEquals(expectedResult, actualResult);
	}
}
