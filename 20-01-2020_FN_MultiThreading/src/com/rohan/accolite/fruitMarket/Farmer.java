package com.rohan.accolite.fruitMarket;

import java.util.Random;

public class Farmer implements Runnable {

	@Override
	public void run() {

		// A count to regularize the flow of fruit production.
		// A farmer can sell 3 fruits in the market continuously, then sleeps for 10s
		int count = 3;

		while (true) {
			synchronized (Market.fruits) {
				
				// A farmer will randomnly produce a fruit among the four mentioned in the main
				int random = new Random().nextInt(Market.fruitsSelection.length);
				String fruit = Market.fruitsSelection[random];

				// If market is full, farmer waits for customer to buy fruits
				if (Market.maxCount == Market.getSum()) {
					try {
						Market.fruits.wait();
					} catch (InterruptedException e) {
						System.out.println(e);
					}
				} else if (count == 0) { // Condition to stop farmer from continuously dominating the market
					try {
						Market.fruits.wait();
						Thread.sleep(10000);
						count = 3;
					} catch (InterruptedException e) {
						System.out.println(e);
					}
				} else {
					System.out.println(Thread.currentThread().getName() + " produced: " + fruit);
					
					// Base case, check if the HasMap has the fruit entry
					if (Market.fruits.containsKey(fruit))
						Market.fruits.put(fruit, Market.fruits.get(fruit) + 1);
					else
						Market.fruits.put(fruit, 1);
					
					System.out.println("Fruit Market has " + Market.getSum() + " fruits");
					
					Market.fruits.notifyAll();
					count--;
				}
				try {
					// After adding the fruit, the farmer goes back to his/her farm to collect more cultivated fruits
					// Due to traffic, the time to bring new fruits may vary
					int sleep = new Random().nextInt(10) * 1000;
					Thread.sleep(sleep);
				} catch (InterruptedException e) {
					System.out.println(e);
				}
			}
		}
	}

}
