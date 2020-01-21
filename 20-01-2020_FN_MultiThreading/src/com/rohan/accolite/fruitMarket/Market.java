package com.rohan.accolite.fruitMarket;

import java.util.*;

public class Market {

	// HashMap to store the number of fruits that are present in the market
	static HashMap<String, Integer> fruits = new HashMap<>();
	
	// The capacity of the market, the farmers don't want the fruits to rot!
	static int maxCount = 10;
	
	// Sadly it is the first month, and the farmers can only sell four types of fruits.
	static String fruitsSelection[] = { "Apple", "Banana", "Strawberry", "Mango" };

	// Function to return the number of fruits currently on sale in the market
	public static int getSum() {
		int sum = 0;
		for (String str : fruits.keySet())
			sum += fruits.get(str);
		return sum;
	}

	public static void main(String args[]) throws InterruptedException {
		
		System.out.println("|==================================================|");
		System.out.println("|Mumbai's one and only place for all fresh fruits!!|");
		System.out.println("|==================================================|");
		
		
		// Four farmers and four customers are present in the market for the endless cycle of the market sale
		for (int i = 1; i <= 4; i++) {
			new Thread(new Farmer(), "Farmer_" + i).start();
			new Thread(new Customer(), "Customer_" + i).start();
		}

	}
}
