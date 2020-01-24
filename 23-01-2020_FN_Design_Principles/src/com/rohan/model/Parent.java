package com.rohan.model;

import java.util.ArrayList;

public class Parent implements Component {

	private ArrayList<Component> houseComponents;
	private int id;
	private String description;
	private String name;
	private int area;

	public Parent(ArrayList<Component> houseComponents, int id, String description, String name) {
		this.houseComponents = houseComponents;
		this.id = id;
		this.description = description;
		this.name = name;
	}

	public int getArea() {
		int sum = 0;
		for (Component houseComponent : houseComponents) {
			sum += houseComponent.getArea();
		}
		this.area = sum;
		return this.area;
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

	public ArrayList<Component> getHouseComponents() {
		return houseComponents;
	}

	public void setHouseComponents(ArrayList<Component> houseComponents) {
		this.houseComponents = houseComponents;
	}

	@Override
	public int getTotalArea() {
		int sum = 0;
		for (Component houseComponent : houseComponents) {
			sum += houseComponent.getTotalArea();
		}
		System.out.println("Area of the " + this.getName() + " is: " + this.getArea() + " square feet");
		return sum;
	}

	@Override
	public String toString() {
		String parent = "=============================================\n";
		for(Component houseComponent: houseComponents)
			parent = parent + houseComponent +"\n";
		parent = parent + "ID: "+id+"\n";
		parent = parent + "Description : "+description+"\n";
		parent = parent + "Name : "+name+"\n";
		parent = parent + "Area : "+area+"\n";
		parent = parent + "=============================================\n";
		return parent;
	}

}
