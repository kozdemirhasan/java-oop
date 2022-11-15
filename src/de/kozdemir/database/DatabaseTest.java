package de.kozdemir.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseTest {

	private static final String URL = "jdbc:sqlite:data.db";

	public static void main(String[] args) {

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
//				System.out.println("Wurde gelöscht...");
//			}else {
//				System.out.println("Wurde NICHT gelöscht...");								
//			}
			
			
//			//update
//			int num = stmt.executeUpdate("UPDATE users SET firstname = 'Hans' WHERE id =1");
//			if(num>0) {
//				System.out.println("Wurde geändert...");
//			}else {
//				System.out.println("Wurde NICHT geändert...");								
//			}
			
			
			
			//select
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
