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
public class Seller {
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
	private String sellerName;
	
	@OneToMany
	@JoinTable(name = "SHOP_PRODUCTS", joinColumns = @JoinColumn(name = "SHOP_ID"), inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
	private List<Products> products;
	
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "locality", column = @Column(name = "SHOP_ADDRESS_LOCALITY"))})
	private ShopAddress sellerShopAddress;

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	public Address getSellerShopAddress() {
		return sellerShopAddress;
	}

	public void setSellerShopAddress(ShopAddress sellerShopAddress) {
		this.sellerShopAddress = sellerShopAddress;
	}
	
	public void addProduct(Products product) {
		if(this.products == null)
			this.products = new ArrayList<>();
		this.products.add(product);
	}

	@Override
	public String toString() {
		return "Seller [sellerName=" + sellerName + ", products=" + products + ", sellerShopAddress="
				+ sellerShopAddress + "]";
	}
}
