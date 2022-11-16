package de.kozdemir.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// CRUD
public class UserRepository {
	
	private static final String URL = "jdbc:sqlite:data.db";
	
	public boolean save(User u) throws SQLException {
		
		if(u.getId() > 0) {
			return update(u);
		}
		
		return insert(u);
	}
	
	private boolean insert(User u) throws SQLException {
		throw new UnsupportedOperationException("Noch nicht implementiert");
	}
	
	private boolean update(User u) throws SQLException {
		throw new UnsupportedOperationException("Noch nicht implementiert");
	}
	
	public boolean delete(User u) throws SQLException {
		return delete(u.getId());
	}
	
	public boolean delete(int id) throws SQLException {
		throw new UnsupportedOperationException("Noch nicht implementiert");
	}
	
	public List<User> find() throws SQLException {
		
		List<User> users = new ArrayList<>();
		
		// Verbindung zur DB aufbauen
		try(Connection con = DriverManager.getConnection(URL);
				Statement stmt = con.createStatement()) {
			
			// Relationale-Daten aus der DB abfragen
			ResultSet results = stmt.executeQuery("SELECT * FROM users");
			
			while(results.next()) {
				// Relationale-Daten in User-Objekte verpacken und in eine Liste ablegen
				User u = new User(results.getInt("id"), results.getString("firstname"), results.getString("lastname"));
				users.add(u);
			}
		}
		
		// Liste mit User-Objekten an den Aufrufer der find-Methode zurückgeben
		return users;
	}
	
	public User findById(int id) throws SQLException {
		
		try(Connection con = DriverManager.getConnection(URL);
				Statement stmt = con.createStatement()) {
			
			ResultSet results = stmt.executeQuery("SELECT * FROM users WHERE id = " + id);
			
			if(results.next()) {
				return new User(results.getInt("id"), results.getString("firstname"), results.getString("lastname"));
			}
			
			// TODO: statt NULL lieber ein Optional zurückgeben
			return null;
		}
	}
}
