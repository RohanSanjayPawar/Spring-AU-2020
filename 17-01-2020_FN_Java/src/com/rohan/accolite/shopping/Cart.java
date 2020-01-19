package com.rohan.accolite.shopping;

import java.util.*;

public class Cart {
	private int user_id;
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private int total_cost;
	private HashMap<Product, Integer> product_list;
	private int wallet;
	private HashMap<Integer, Order> orderList;
	public static int idCount = 0;
	
	public int getWallet() {
		return wallet;
	}

	public void setWallet(int wallet) {
		this.wallet = wallet;
	}

	public int getUser_id() {
		return this.user_id;
	}
	
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public int getTotal_cost() {
		int sum = 0;
		for(Product product: this.product_list.keySet())
			sum += product.getProduct_cost()*this.product_list.get(product);
		this.total_cost = sum;
		return this.total_cost;
	}
	
	public HashMap<Product, Integer> getProduct_list() {
		return this.product_list;
	}
	
	public void addProduct(Product product) {
		if(this.product_list == null)
			this.product_list = new HashMap<Product, Integer>();
		if(this.product_list.containsKey(product))
			this.product_list.put(product, this.product_list.get(product)+1);
		else 
			this.product_list.put(product, 1);
	}
	
	public void removeProduct(Product product) {
		if(this.product_list.get(product) == 1)
			this.product_list.remove(product);
		else
			this.product_list.put(product, this.product_list.get(product)-1);
	}
	
	public void placeOrder() {
		if(this.orderList == null)
			this.orderList = new HashMap<>();
		Order order = new Order();
		order.setOrder_id(this.user_id+Cart.idCount);
		@SuppressWarnings("unchecked")
		HashMap<Product, Integer> temp = (HashMap<Product, Integer>) this.product_list.clone();
		order.setProductList(temp);
		order.setTotal_bill(this.total_cost);
		this.orderList.put(this.user_id+Cart.idCount, order);
		this.wallet = this.wallet-this.getTotal_cost();
		this.product_list.clear();
		Cart.idCount++;
	}
	
	public HashMap<Integer, Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(HashMap<Integer, Order> orderList) {
		this.orderList = orderList;
	}

	public Order cancelOrder(int id) {
		Order order = this.orderList.get(id);
		this.wallet += order.getTotal_bill();
		this.orderList.remove(id);
		return order;
	}
}
