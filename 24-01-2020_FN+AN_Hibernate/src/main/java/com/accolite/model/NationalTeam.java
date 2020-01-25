package com.accolite.model;

import javax.persistence.Entity;

@Entity
public class NationalTeam extends Team {
	private String nationName;
	@Override
	public String toString() {
		return "NationalTeam [nationName=" + nationName + ", present=" + present + "]";
	}

	private boolean present;

	public String getClubName() {
		return nationName;
	}

	public void setNationName(String nationName) {
		this.nationName = nationName;
	}

	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}

	public int getId() {
		return super.getId();
	}

	public void setId(int id) {
		super.setId(id);
	}

	public int getGoals() {
		return super.getGoals();
	}

	public void setGoals(int goals) {
		super.setGoals(goals);
	}
}
