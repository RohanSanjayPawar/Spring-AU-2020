package com.accolite.playerInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.accolite.model.ClubTeam;
import com.accolite.model.NationalTeam;
import com.accolite.model.Player;

public class App {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		boolean loop = true;

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		do {
			System.out.println("|========================|");
			System.out.println("|PLAYER INFORMATION MENU!|");
			System.out.println("|========================|");

			System.out.println("1. Show all Players");
			System.out.println("2. Add a new Player");
			System.out.println("3. Update a Player");
			System.out.println("4. Delete a Player");
			System.out.println("5. Exit");
			System.out.print("\nPlease enter a choice: ");
			int choice = 0;
			try {
				choice = sc.nextInt();
			} catch (Exception e) {
				System.out.println("Please enter a valid choice");
			}

			int id = 4;

			switch (choice) {
			case 1:
				List<Player> playerList = new ArrayList<>();
				session.beginTransaction();
				try {
					// Named Query
					playerList = session.createNamedQuery("Player.getPlayer").getResultList();
					for (Player playerElement : playerList) {
						System.out.println(playerElement.toString());
					}
				} catch (Exception e) {
					System.out.println(e);
				}
				session.getTransaction().commit();
				break;

			case 2:
				Player player = new Player();
				player.setName("Lionel Messi");

				ClubTeam club1 = new ClubTeam();
				club1.setClubName("FC Barcelona");
				club1.setPresent(true);
				club1.setGoals(600);

				ClubTeam club2 = new ClubTeam();
				club2.setClubName("Ajax FC");
				club2.setPresent(false);
				club2.setGoals(200);

				Collection<ClubTeam> clubs = new ArrayList<>();
				clubs.add(club1);
				clubs.add(club2);
				player.setClubs(clubs);

				NationalTeam nationalTeam = new NationalTeam();
				nationalTeam.setGoals(400);
				nationalTeam.setNationName("Argentina");
				nationalTeam.setPresent(true);

				player.setNationalTeam(nationalTeam);
				player.setGoals();

				session.beginTransaction();
				session.save(club1);
				session.save(club2);
				session.save(nationalTeam);
				session.save(player);
				session.getTransaction().commit();
				break;

			case 3:
				id = 4;
				session.beginTransaction();
				try {
					Player tempPlayer = session.load(Player.class, id);
					tempPlayer.setName("Lionel A Messi");
					System.out.println("Updated the player successfully!");
					System.out.println(tempPlayer.toString());
				} catch (Exception e) {
					System.out.println("Player record not found!");
				}
				session.getTransaction().commit();
				break;

			case 4:
				id = 1;
				session.beginTransaction();
				try {
					Player deletedPlayer = session.load(Player.class, id);
					session.delete(deletedPlayer);
					System.out.println("Deleted the player successfully!");
					System.out.println(deletedPlayer.toString());
				} catch (Exception e) {
					System.out.println("Player record not found!");
				}
				session.getTransaction().commit();
				break;

			case 5:
				System.out.println("Thanks for coming to the player info portal!");
				loop = false;
				session.close();
				break;

			default:
				System.out.println("Please enter a valid choice");
			}
		} while (loop);
		sc.close();
	}

}
