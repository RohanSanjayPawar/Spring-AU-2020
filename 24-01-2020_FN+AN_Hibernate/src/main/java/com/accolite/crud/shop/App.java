package com.accolite.crud.shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.accolite.crud.model.Customer;
import com.accolite.crud.model.HomeAddress;
import com.accolite.crud.model.Products;
import com.accolite.crud.model.Seller;
import com.accolite.crud.model.ShopAddress;

public class App {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		boolean loop = true;

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		System.out.println("WELCOME TO SHOPPING CART!");
		System.out.println("Please verify yourself!");
		System.out.println("1. Customer");
		System.out.println("2. Seller");
		int type = 0;
		try {
			type = sc.nextInt();
		} catch (Exception e) {
			System.out.println("Please enter a valid choice");
		}

		switch (type) {
		case 1:
			Customer user = new Customer();
			user.setUserName("theUnderMiner");
			user.setCustomerName("Rohan Pawar");
			user.setPassword("12345678");

			HomeAddress homeAddress = new HomeAddress();
			homeAddress.setCity("Mumbai");
			homeAddress.setStreetName("Bandra");
			homeAddress.setLocality("PVR");
			homeAddress.setLandLine("123");

			user.setDeliveryAddress(homeAddress);
			session.beginTransaction();
			session.save(homeAddress);
			session.save(user);
			session.getTransaction().commit();

			do {
				System.out.println("|========================|");
				System.out.println("|  SHOPPING CART MENU!   |");
				System.out.println("|========================|");

				System.out.println("1. Show all Products");
				System.out.println("2. Add to cart");
				System.out.println("3. Remove from cart");
				System.out.println("4. Checkout");
				System.out.println("5. Cancel Order");
				System.out.println("6. Exit");
				System.out.print("\nPlease enter a choice: ");
				int choice = 0;
				try {
					choice = sc.nextInt();
				} catch (Exception e) {
					System.out.println("Please enter a valid choice");
				}

				int id = 3;

				switch (choice) {
				case 1:
					List<Products> productList = new ArrayList<>();
					session.beginTransaction();
					try {
						// Named Query
						productList = session.createNamedQuery("Products.getProducts").getResultList();
						for (Products product : productList) {
							System.out.println(product.toString());
						}
					} catch (Exception e) {
						System.out.println(e);
					}
					session.getTransaction().commit();
					break;

				case 2:
					Products product = new Products();
					product.setProductName("OnePlus 6");
					product.setProductPrice(35000);
					user.addProduct(product);

					session.beginTransaction();
					session.save(product);
					session.saveOrUpdate(user);
					session.getTransaction().commit();
					break;

				case 3:
					id = 3;
					session.beginTransaction();
					try {
						Products tempProduct = session.load(Products.class, id);
						Customer customer = session.load(Customer.class, id-1);
						customer.getProductsList().remove(tempProduct);
						session.saveOrUpdate(customer);
						session.delete(tempProduct);
						System.out.println("Deleted the product successfully!");
						System.out.println(tempProduct.toString());
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("Product record not found!");
					}
					session.getTransaction().commit();
					break;

				case 4:
					// Simple checkout
					System.out.println("Successfully Placed order!");
					break;

				case 5:
					id = 3;
					session.beginTransaction();
					try {
						Products tempProduct = session.load(Products.class, id);
						Customer customer = session.load(Customer.class, id-1);
						customer.getProductsList().remove(tempProduct);
						session.saveOrUpdate(customer);
						session.delete(tempProduct);
						System.out.println("Deleted the product successfully!");
						System.out.println(tempProduct.toString());
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("Product record not found!");
					}
					session.getTransaction().commit();
					break;

				case 6:
					System.out.println("Thanks for coming to the shopping cart!");
					loop = false;
					session.close();
					break;

				default:
					System.out.println("Please enter a valid choice");
				}
			} while (loop);
			break;
		case 2:
			Seller seller = new Seller();
			seller.setUserName("dmart");
			seller.setSellerName("Akash Jain");
			seller.setPassword("12345678");

			ShopAddress shopAddress = new ShopAddress();
			shopAddress.setCity("Mumbai");
			shopAddress.setStreetName("Andheri");
			shopAddress.setLocality("Metro");
			shopAddress.setShopNumber("123121");

			seller.setSellerShopAddress(shopAddress);
			session.beginTransaction();
			session.save(shopAddress);
			session.save(seller);
			session.getTransaction().commit();

			do {
				System.out.println("|========================|");
				System.out.println("|  SHOPPING CART MENU!   |");
				System.out.println("|========================|");

				System.out.println("1. Add new Product");
				System.out.println("2. Remove a Product");
				System.out.println("3. Exit");
				System.out.print("\nPlease enter a choice: ");
				int choice = 0;
				try {
					choice = sc.nextInt();
				} catch (Exception e) {
					System.out.println("Please enter a valid choice");
				}

				int id = 3;

				switch (choice) {
				case 1:
					Products product = new Products();
					product.setProductName("OnePlus 7 Pro");
					product.setProductPrice(52000);
					seller.addProduct(product);

					session.beginTransaction();
					session.save(product);
					session.saveOrUpdate(seller);
					session.getTransaction().commit();
					break;

				case 2:
					id = 3;
					session.beginTransaction();
					try {
						Products tempProduct = session.load(Products.class, id);
						Seller tempSeller = session.load(Seller.class, id-1);
						tempSeller.getProducts().remove(tempProduct);
						session.saveOrUpdate(tempSeller);
						session.delete(tempProduct);
						System.out.println("Deleted the product successfully!");
						System.out.println(tempProduct.toString());
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("Product record not found!");
					}
					session.getTransaction().commit();
					break;

				case 3:
					System.out.println("Thanks for coming to the shopping cart!");
					loop = false;
					session.close();
					break;

				default:
					System.out.println("Please enter a valid choice");
				}
			} while (loop);
			break;
		default:
			System.out.println("Please enter a valid choice");
			break;
		}

		sc.close();
	}
}
