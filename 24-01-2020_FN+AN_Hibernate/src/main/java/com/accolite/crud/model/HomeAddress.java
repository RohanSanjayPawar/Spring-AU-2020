package com.accolite.crud.model;

import javax.persistence.Entity;

@Entity
public class HomeAddress extends Address {
	private String locality;
	private String landline;

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getLandline() {
		return landline;
	}

	public void setLandLine(String landline) {
		this.landline = landline;
	}

}
