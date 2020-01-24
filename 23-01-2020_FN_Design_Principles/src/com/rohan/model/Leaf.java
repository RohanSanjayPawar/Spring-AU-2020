package com.rohan.model;

public class Leaf implements Component {

	private int id;
	private String description;
	private String name;
	private int area;

	public Leaf(int id, String description, String name, int area) {
		this.id = id;
		this.description = description;
		this.name = name;
		this.area = area;
	}

	@Override
	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int getId() {
		return this.id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getTotalArea() {
		return this.area;
	}
	
	@Override
	public String toString() {
		String leaf = "---------------------------------------------\n";
		leaf = leaf + "ID: "+id+"\n";
		leaf = leaf + "Description : "+description+"\n";
		leaf = leaf + "Name : "+name+"\n";
		leaf = leaf + "Area : "+area+"\n";
		leaf = leaf + "---------------------------------------------\n";
		return leaf;
	}

}
