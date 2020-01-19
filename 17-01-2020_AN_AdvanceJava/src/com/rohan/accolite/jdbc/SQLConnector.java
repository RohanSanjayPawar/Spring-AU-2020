package com.rohan.accolite.jdbc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.*;

/* MySQL workbench code
 
CREATE DATABASE JDBC;

USE JDBC;

CREATE TABLE PLAYERS(player_id INT, player_name VARCHAR(50), age INT, club VARCHAR(50));

CREATE TABLE CLUB(club_id INT, club VARCHAR(50));

INSERT INTO PLAYERS VALUES(1, 'Lionel Messi', 32, 'FC Barcelona');
INSERT INTO PLAYERS VALUES(2, 'Cristiano Ronaldo', 34, 'Juventus');
INSERT INTO PLAYERS VALUES(3, 'Sadio Mane', 26, 'Liverpool');
INSERT INTO PLAYERS VALUES(4, 'Paulo Dybala', 23, 'Juventus');
INSERT INTO PLAYERS VALUES(5, 'Luis Suarez', 35, 'FC Barcelona');
INSERT INTO PLAYERS VALUES(6, 'Frankie De Jong', 25, 'FC Barcelona');

INSERT INTO CLUB VALUES(101, 'FC Barcelona');
INSERT INTO CLUB VALUES(102, 'Juventus');
INSERT INTO CLUB VALUES(103, 'Liverpool');
INSERT INTO CLUB VALUES(104, 'Manchester City');

DELIMITER //

CREATE PROCEDURE JoinPlayersClub()
BEGIN
    SELECT * 
    FROM PLAYERS p INNER JOIN CLUB c
    ON p.club = c.club;
END //
 
DELIMITER ;
*/

public class SQLConnector {
	public static Connection con;
	
	public static void main(String args[]) {
		try {
			connectToMySQL();
			
			CallableStatement statement = null;
			String query = "{CALL JoinPlayersClub()}";
			statement = con.prepareCall(query);
            ResultSet result = statement.executeQuery();
            
            List<PlayerJoinClub> list = new LinkedList<>();
            
            while(result.next()) {
            	PlayerJoinClub row = new PlayerJoinClub();
            	row.setPlayer_id(result.getInt("player_id"));
            	row.setPlayer_name(result.getString("player_name"));
            	row.setAge(result.getInt("age"));
            	row.setClub(result.getString("club"));
            	row.setClub_id(result.getInt("club_id"));
            	
            	list.add(row);
            }
            
            System.out.println("PlayerID\tPlayerName\t\tAge\tClub\t\t\tClubID");
            for(PlayerJoinClub rows: list) {
            	System.out.println(rows);
            }
            con.close();
        } catch(Exception e) {
            System.err.println("Error 4: "+e.getMessage());
        }
	}
	
	public static void connectToMySQL() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC","root","Rohan@2008");
	    } catch (ClassNotFoundException e) {
	        System.err.println("Error 1: "+e.getMessage());
	    } catch (SQLException e) {
	        System.err.println("Error 2: "+e.getMessage());
	    } catch (Exception e) {
	        System.err.println("Error 3: "+e.getMessage());
	    }
	}
}
