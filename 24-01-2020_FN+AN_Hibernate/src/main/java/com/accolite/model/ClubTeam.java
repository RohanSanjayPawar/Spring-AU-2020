package com.accolite.model;

import javax.persistence.Entity;

// Players play for clubs (state level)
@Entity
public class ClubTeam extends Team {
	private int id;
	private int goals;
	private String clubName;
	private boolean present;

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGoals() {
		return this.goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}

	@Override
	public String toString() {
		return "ClubTeam [id=" + id + ", goals=" + goals + ", clubName=" + clubName + ", present=" + present + "]";
	}
}
