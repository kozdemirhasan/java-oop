package de.kozdemir.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class DatabaseTest {

	private static final String URL = "jdbc:sqlite:data.db";

	public static void main(String[] args) {

		UserRepository repo = new UserRepository();
		try {

			// Alle abfragen
			List<User> users = repo.find();
			final String ROW = "%10s | %-10s | %-10s \n";
			for (User u : users) {
				System.out.printf(ROW, u.getId() , u.getFirstname() , " " + u.getLastname());
			}
//			
//			// Einen abfragen
//			User u = repo.findById(1);
//			System.out.println(u.getFirstname() + " " + u.getLastname());

		} catch (UnsupportedOperationException e) {
			System.out.println("Funktion ist noch nicht eingebaut.");
		} catch (Exception e) {
			System.out.println("Probleme: " + e.getMessage());
		}

		System.exit(0);
		
		/*********************************************************************************************/

		try (Connection con = DriverManager.getConnection(URL); Statement stmt = con.createStatement()) {

//			//insert	
//			int num = stmt.executeUpdate("INSERT INTO users (firstname, lastname) VALUES('Osman', 'Demir')");
//			if(num>0) {
//				System.out.println("Wurde gespeichert...");
//			}else {
//				System.out.println("Wurde NICHT gespeichert...");								
//			}

//			//delete
//			int num = stmt.executeUpdate("DELETE FROM users WHERE id=8");
//			if(num>0) {
//				System.out.println("Wurde gel�scht...");
//			}else {
//				System.out.println("Wurde NICHT gel�scht...");								
//			}

//			//update
//			int num = stmt.executeUpdate("UPDATE users SET firstname = 'Hans' WHERE id =1");
//			if(num>0) {
//				System.out.println("Wurde ge�ndert...");
//			}else {
//				System.out.println("Wurde NICHT ge�ndert...");								
//			}

			// select
			ResultSet results = stmt.executeQuery("SELECT * FROM users");

			final String ROW = "%10s | %-10s | %-10s \n";

			while (results.next()) {
				System.out.printf(ROW, results.getString("id"), results.getString("firstname"),
						results.getString("lastname"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
