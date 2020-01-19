package com.rohan.accolite.shopping;

import java.util.HashMap;

public class Shop {
	private int shop_id;
	private HashMap<Product, Integer> inventory;
	
	public int getShop_id() {
		return shop_id;
	}
	
	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}
	
	public HashMap<Product, Integer> getInventory() {
		return inventory;
	}
	
	public void addInventory(Product product, int quantity) {
		if(this.inventory == null)
			this.inventory = new HashMap<Product, Integer>();
		
		if(this.inventory.containsKey(product))
			this.inventory.put(product, this.inventory.get(product)+quantity);
		else 
			this.inventory.put(product, quantity);
	}
	
	public boolean checkAvailability(Product product) {
		return this.inventory.get(product) > 0;
	}
	
	public void removeProduct(Product product) {
		if(checkAvailability(product))
			this.inventory.put(product, this.inventory.get(product)-1);
	}
}
