package com.accolite.crud.model;

import javax.persistence.Entity;

@Entity
public class ShopAddress extends Address {
	private String locality;
	private String shopNumber;

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getShopNumber() {
		return shopNumber;
	}

	public void setShopNumber(String shopNumber) {
		this.shopNumber = shopNumber;
	}

}
