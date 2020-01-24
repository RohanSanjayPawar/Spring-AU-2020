package com.rohan.construction;

import java.util.ArrayList;

import com.rohan.model.Component;
import com.rohan.model.Leaf;
import com.rohan.model.Parent;

public class Construction {
	
	public static void main(String args[]) {
		
		// ========================== Flat 1 Start
 		Leaf hall1 = new Leaf(1, "Spacious hall", "Hall", 200);
		Leaf kitchen1 = new Leaf(2, "Compact Kitchen", "Kitchen", 130);
		Leaf bedroom11 = new Leaf(3, "Middle Bedroom", "Bedroom", 200);
		Leaf bedroom12 = new Leaf(4, "Master Bedroom", "Bedroom", 200);
		
		ArrayList<Component> rooms1 = new ArrayList<>();
		rooms1.add(hall1);
		rooms1.add(kitchen1);
		rooms1.add(bedroom11);
		rooms1.add(bedroom12);
		Parent flat1 = new Parent(rooms1, 101, "Lavish 2BHK", "Flat no. 101");
		// ========================== Flat 1 End
		
		
		// ========================== Flat 2 Start
		Leaf hall2 = new Leaf(5, "Furnished Hall", "Hall", 210);
		Leaf kitchen2 = new Leaf(6, "Modern Kitchen", "Kitchen", 200);
		Leaf bedroom21 = new Leaf(7, "Middle Bedroom", "Bedroom", 250);
		Leaf bedroom22 = new Leaf(8, "Master Bedroom", "Bedroom", 300);
		
		ArrayList<Component> rooms2 = new ArrayList<>();
		rooms2.add(hall2);
		rooms2.add(kitchen2);
		rooms2.add(bedroom21);
		rooms2.add(bedroom22);
		Parent flat2 = new Parent(rooms2, 102, "Lavish 2BHK", "Flat no. 102");
		// ========================== Flat 2 End
		
		// ========================== Flat 3 Start
		Leaf hall3 = new Leaf(9, "Hall with Balcony", "Hall", 200);
		Leaf kitchen3 = new Leaf(10, "Modern Kitchen", "Kitchen", 200);
		Leaf bedroom31 = new Leaf(11, "Middle Bedroom", "Bedroom", 250);
		Leaf bedroom32 = new Leaf(12, "Master Bedroom1", "Bedroom", 300);
		Leaf bedroom33 = new Leaf(13, "Master Bedroom2", "Bedroom", 300);
		
		ArrayList<Component> rooms3 = new ArrayList<>();
		rooms3.add(hall3);
		rooms3.add(kitchen3);
		rooms3.add(bedroom31);
		rooms3.add(bedroom32);
		rooms3.add(bedroom33);
		Parent flat3 = new Parent(rooms3, 103, "Lavish 3BHK", "Flat no. 103");
		// ========================== Flat 3 End
		
		// ========================== FLoor Start
		ArrayList<Component> flats = new ArrayList<>();
		flats.add(flat1);
		flats.add(flat2);
		flats.add(flat3);
		
		Parent floor = new Parent(flats, 201, "1st Floor", "Floor");
		// ========================== Floor End
		
		// ========================== Building Start
		ArrayList<Component> floors = new ArrayList<>();
		floors.add(floor);
		
		Parent building = new Parent(floors, 301, "Obeya Elan Apartments", "Building");
		// ========================== Building End
		
		// ========================== Logic
		System.out.println("|=================================|");
		System.out.println("|Welcome to Obeya Elan Apartments!|");
		System.out.println("|=================================|");
		System.out.println("The number of floors in the apartment is: "+floors.size());
		System.out.println("The number of flats in each floor is: "+flats.size());
		System.out.println("\n\nBuilding Overview: \n");
		int totalArea = building.getTotalArea();
		System.out.println("Total area of the building is: "+totalArea);
		
		System.out.println("\n\nDescription of each flat: \n");
		for(Component component: floors) 
			System.out.println(component);
	}
	
}
