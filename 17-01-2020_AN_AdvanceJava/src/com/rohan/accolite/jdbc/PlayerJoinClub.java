package com.rohan.accolite.jdbc;

public class PlayerJoinClub {
	private int player_id;
	private String player_name;
	private int age;
	private String club;
	private int club_id;
	
	public int getPlayer_id() {
		return player_id;
	}
	
	public void setPlayer_id(int player_id) {
		this.player_id = player_id;
	}
	
	public String getPlayer_name() {
		return player_name;
	}
	
	public void setPlayer_name(String player_name) {
		this.player_name = player_name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getClub() {
		return club;
	}
	
	public void setClub(String club) {
		this.club = club;
	}
	
	public int getClub_id() {
		return club_id;
	}
	
	public void setClub_id(int club_id) {
		this.club_id = club_id;
	}	
	
	@Override
	public String toString() {
		// For better formatting
		if(this.player_name.length() > 15)
			return this.player_id + "\t\t" + this.player_name + "\t" + this.age + "\t" + this.club + "\t\t" + this.club_id;
		return this.player_id + "\t\t" + this.player_name + "\t\t" + this.age + "\t" + this.club + "\t\t" + this.club_id;
	}
}
