package com.rohan.accolite.shopping;

public class Product {
	private int product_id;
	private String product_name;
	private int product_cost;

	
	public int getProduct_id() {
		return this.product_id;
	}
	
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	
	public String getProduct_name() {
		return this.product_name;
	}
	
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	
	public int getProduct_cost() {
		return this.product_cost;
	}
	
	public void setProduct_cost(int product_cost) {
		this.product_cost = product_cost;
	}
}
