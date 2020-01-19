package com.rohan.accolite.shopping;

import java.util.*;

public class Order {
	private int order_id;
	private HashMap<Product, Integer> product_list;
	private int total_bill;
	
	public int getTotal_bill() {
		return total_bill;
	}
	public void setTotal_bill(int total_bill) {
		this.total_bill = total_bill;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	
	public HashMap<Product, Integer> getProductList() {
		return this.product_list;
	}
	
	public void setProductList(HashMap<Product, Integer> list) {
		this.product_list = list;
	}
}
