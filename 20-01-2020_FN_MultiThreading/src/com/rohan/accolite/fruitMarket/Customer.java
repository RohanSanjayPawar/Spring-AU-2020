package com.rohan.accolite.fruitMarket;

import java.util.Random;

public class Customer {

	Runnable customer = () -> {
		// A count to regularize the outflow of fruits.
		// A customer can buy 3 fruits in the market continuously, then sleeps for 10s
		int count = 3;

		while (true) {
			synchronized (Market.fruits) {

				// The customer is picky and picks random fruit every day
				int random = new Random().nextInt(Market.fruitsSelection.length);
				String fruit = Market.fruitsSelection[random];

				// The customer waits for the fruit that he/she wants to be available
				if (!Market.fruits.containsKey(fruit) || Market.fruits.get(fruit) == 0) {
					try {
						Market.fruits.wait();
					} catch (InterruptedException e) {
						System.out.println(e);
					}
				} else if (count == 0) { // Condition to stop customer from buying the whole market!
					try {
						Market.fruits.wait();
						Thread.sleep(10000);
						count = 3;
					} catch (InterruptedException e) {
						System.out.println(e);
					}
				} else {
					Market.fruits.put(fruit, Market.fruits.get(fruit) - 1);
					System.out.println(Thread.currentThread().getName() + " bought: " + fruit + " from the market");
					System.out.println("Remaining fruits in the market: " + Market.getSum());
					Market.fruits.notifyAll();
					count--;

					// Customer buys fruits at different time each day.
					try {
						int sleep = new Random().nextInt(10) * 1000;
						Thread.sleep(sleep);
					} catch (InterruptedException e) {
						System.out.println(e);
					}
				}
			}
		}
	};
}
