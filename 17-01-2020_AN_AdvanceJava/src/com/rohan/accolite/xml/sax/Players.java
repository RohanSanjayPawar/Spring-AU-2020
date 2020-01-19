package com.rohan.accolite.xml.sax;

public class Players {
	private int id;
	private String firstname;
	private String lastname;
	private int age;
	private String nationality;
	private String club;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	@Override
	public String toString() {
		return "Player:\n"+ "ID=" + this.id + "\nName=" + this.firstname+" "+this.lastname + "\nAge=" + this.age + "\nNationality=" + this.nationality
				+ "\nClub=" + this.club;
	}
}
