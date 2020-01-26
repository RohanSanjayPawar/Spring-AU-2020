package com.accolite.crud.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String userName;
	private String password;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	private String customerName;
	
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "locality", column = @Column(name = "HOME_ADDRESS_LOCALITY"))})
	private HomeAddress deliveryAddress;
	
	private int wallet;
	
	@OneToMany
	@JoinTable(name = "BUYER_PRODUCTS", joinColumns = @JoinColumn(name = "CUSTOMER_ID"), inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
	private List<Products> productsList;

	public int getWallet() {
		return wallet;
	}

	public void setWallet(int wallet) {
		this.wallet = wallet;
	}

	public List<Products> getProductsList() {
		return productsList;
	}

	public void setProductsList(List<Products> productsList) {
		this.productsList = productsList;
	}
	
	public void addProduct(Products product) {
		if(this.productsList == null)
			this.productsList = new ArrayList<>();
		this.productsList.add(product);
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(HomeAddress deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", deliveryAddress=" + deliveryAddress + "]";
	}
}
