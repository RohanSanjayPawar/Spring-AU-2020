package com.rohan.accolite.shopping;

import java.util.*;
import java.io.*; 

public class Main {
	
	public static Shop shop;
	public static Cart cart;
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		
		fillInventory();
		
		// Initialize the user cart;
		System.out.print("Enter user name:");
		String userName = sc.next();
		cart = new Cart();
		cart.setName(userName);
		cart.setUser_id(7);
		cart.setWallet(100000);
		boolean missInp = false;
		do {
			System.out.println("===================================================");
			System.out.println("SHOPPING CART");
			System.out.println("===================================================");
			System.out.println("1. View Available Products");
			System.out.println("2. View Cart");
			System.out.println("3. Add to Cart");
			System.out.println("4. Remove from Cart");
			System.out.println("5. Clear the Cart");
			System.out.println("6. Place Order");
			System.out.println("7. Cancel Order");
			System.out.println("8. Exit");
			System.out.println("What would you like to explore? (Enter a number)");
			int choice = 0;
			missInp = false;
			try {
				choice = Integer.parseInt(sc.next());
			} catch(NumberFormatException e) {
				missInp = true;
				System.out.println("Please enter a valid number!");
			}
			if(!missInp) {
				System.out.println("===================================================");
				switch(choice) {
					case 1:
						System.out.println("Available Products:\n");
						System.out.println("ID\t\tName\t\tPrice\t\tQuantity");
						for(Product product: shop.getInventory().keySet()) {
							System.out.println(product.getProduct_id()+"\t\t"+product.getProduct_name()+"\t\t"+product.getProduct_cost()+"\t\t"+shop.getInventory().get(product));
						}
						break;
					case 2: 
						if(cart.getProduct_list() == null || cart.getProduct_list().size() == 0)
							System.out.println("Your cart is empty!");
						else {
							System.out.println("Your Cart is:\n");
							System.out.println("ID\t\tName\t\tPrice\t\tQuantity");
							for(Product product: cart.getProduct_list().keySet()) {
								System.out.println(product.getProduct_id()+"\t\t"+product.getProduct_name()+"\t\t"+product.getProduct_cost()+"\t\t"+cart.getProduct_list().get(product));
							}
							
							System.out.println("\nTotal Cart Value: "+cart.getTotal_cost());
						}
						break;
					case 3:
						System.out.println("Available Products:\n");
						System.out.println("ID\t\tName\t\tPrice\t\tQuantity");
						for(Product product: shop.getInventory().keySet()) {
							System.out.println(product.getProduct_id()+"\t\t"+product.getProduct_name()+"\t\t"+product.getProduct_cost()+"\t\t"+shop.getInventory().get(product));
						}
						System.out.print("Please select an item choice (1-7): ");
						int item = 0;
						boolean miss = false;
						try {
							item = sc.nextInt();
						} catch(InputMismatchException e) {
							miss = true;
							System.out.println("Please enter a valid product id!");
						}
						if(!miss) {
							Product temp = new Product();
							for(Product product: shop.getInventory().keySet()) {
								if(item == product.getProduct_id() && shop.checkAvailability(product)) {
									shop.removeProduct(product);
									temp = product;
								}
							}
							if(temp.getProduct_cost() == 0)
								System.out.println("Please select a valid item!");
							else {
								cart.addProduct(temp);
								int value = cart.getTotal_cost();
								System.out.println("Item added successfully!");
								System.out.println("Cart Value: "+value);
							}
						}
						break;
					case 4:
						if(cart.getProduct_list() == null || cart.getProduct_list().size() == 0)
							System.out.println("Your cart is empty!");
						else {
							System.out.println("Your Cart is:\n");
							System.out.println("ID\t\tName\t\tPrice\t\tQuantity");
							for(Product product: cart.getProduct_list().keySet()) {
								System.out.println(product.getProduct_id()+"\t\t"+product.getProduct_name()+"\t\t"+product.getProduct_cost()+"\t\t"+cart.getProduct_list().get(product));
							}
							
							System.out.println("\nTotal Cart Value: "+cart.getTotal_cost());
							System.out.println("Enter an item to remove:");
							miss=false;
							item = 0;
							try {
								item = sc.nextInt();
							} catch(InputMismatchException e) {
								miss = true;
								System.out.println("Please enter a valid product id!");
							}
							if(!miss) {
								boolean set = false;
								for(Product product: cart.getProduct_list().keySet()) {
									if(item == product.getProduct_id()) {
										cart.removeProduct(product);
										shop.addInventory(product, 1);
										cart.getTotal_cost();
										set = true;
										break;
									}
								}
								if(set)
									System.out.println("Item Successfully Removed!");
								else
									System.out.println("Please select a proper item!");
							}
						}
						break;
					case 5:
						if(cart.getProduct_list() == null || cart.getProduct_list().size() == 0)
							System.out.println("Your cart is empty!");
						else {
							for(Product product: cart.getProduct_list().keySet()) {
								shop.addInventory(product, cart.getProduct_list().get(product));
								cart.getProduct_list().remove(product);
								cart.getTotal_cost();
							}
							System.out.println("Cart cleared successfully!");
						}
						break;
					case 6:
						if(cart.getProduct_list() == null || cart.getProduct_list().size() == 0)
							System.out.println("Your cart is empty!");
						else {
							if(cart.getWallet() < cart.getTotal_cost())
								System.out.println("Insufficient Funds!!");
							else {
								cart.placeOrder();
								System.out.println("Order Placed Successfully!");
								System.out.println("Your current balance: "+cart.getWallet());
							}
						}
						break;
					case 7:
						if(cart.getOrderList() == null || cart.getOrderList().size() == 0)
							System.out.println("You don't have any past orders!");
						else {
							System.out.println("Your Cart is:\n");
							System.out.println("ID\t\tBill");
							for(int id: cart.getOrderList().keySet()) {
								System.out.println(id+"\t\t"+cart.getOrderList().get(id).getTotal_bill());
							}
							System.out.println("Please select an item to delete:");
							item = 0;
							miss = false;
							try {
							item = sc.nextInt();
							} catch(InputMismatchException e) {
								miss = true;
								System.out.println("Please enter a valid product id!");
							}
							if(!miss) {
								Order cancelled = cart.cancelOrder(item);
								if(cancelled == null) {
									System.out.println("Please select a proper order");
								} else {
									for(Product product: cancelled.getProductList().keySet()) {
										System.out.println(product.getProduct_name());
										shop.addInventory(product, cancelled.getProductList().get(product));
									}
									System.out.println("Order cancelled successfully!");
									System.out.println("Your new balance is: "+cart.getWallet());
								}
							}
						}
						break;
					case 8:
						System.out.println("Thank you for coming to the shopping mall!");
						exit = true;
						break;
					default:
						System.out.println("Please enter a valid choice.");
						break;
				}
			}
		} while(!exit);
		sc.close();
	}
	
	// A function to fill up the Shop with products
	public static void fillInventory() throws Exception {
		
		shop = new Shop();
		shop.setShop_id(101);
		
		File file = new File("products.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		while ((line = br.readLine()) != null) { 
			//System.out.println(line);  
			String[] details = line.split(" ");
			Product product = new Product();
			product.setProduct_id(Integer.parseInt(details[0]));
			product.setProduct_name(details[1]);
			product.setProduct_cost(Integer.parseInt(details[2]));
			
			shop.addInventory(product, Integer.parseInt(details[3]));
			
			//System.out.println(product.getProduct_cost());
		}
		br.close();
	}
}
