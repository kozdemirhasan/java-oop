package de.kozdemir.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


// CRUD
public class UserRepository {

	private static final String URL = "jdbc:sqlite:data.db";
	private static final String TABLE = "users";

	public boolean save(User u) throws SQLException {

		if (u.getId() > 0) {
			return update(u);
		}

		return insert(u);
	}

	private boolean insert(User u) throws SQLException {

		// insert
		final String SQL = "INSERT INTO " + TABLE + " (id, firstname, lastname) VALUES(null, ?, ?)";
		try (Connection con = DriverManager.getConnection(URL); PreparedStatement stmt = con.prepareStatement(SQL)) {

			stmt.setString(1, u.getFirstname());
			stmt.setString(2, u.getLastname());

			if (stmt.executeUpdate() > 0) {
				// Abfrage der zuletzt vergebenen ID
				ResultSet keys = con.createStatement().executeQuery("SELECT last_insert_rowid()");
				if (keys.next()) {
					u.setId(keys.getInt("last_insert_rowid()"));
					return true;
				}
			}
			return false;
		}
	}

	private boolean update(User u) throws SQLException {
		final String SQL = "UPDATE " + TABLE + " SET firstname = ?, lastname = ? WHERE id = ?";

		try(Connection con = DriverManager.getConnection(URL);
				PreparedStatement stmt = con.prepareStatement(SQL)) {
			
			stmt.setString(1, u.getFirstname());
			stmt.setString(2, u.getLastname());
			stmt.setInt(3, u.getId());
			
			return stmt.executeUpdate() > 0;
		}
	}

	public boolean delete(User u) throws SQLException {
		return delete(u.getId());
	}

	public boolean delete(int id) throws SQLException {
		final String SQL = "DELETE FROM " + TABLE + " WHERE id = " + id;

		try (Connection con = DriverManager.getConnection(URL); 
				Statement stmt = con.createStatement()) {

			// executeUpdate liefert die Anzahl betroffener Datensätze
			return stmt.executeUpdate(SQL) > 0;
		}
	}

	public List<User> find() throws SQLException {

		List<User> users = new ArrayList<>();

		// Verbindung zur DB aufbauen
		try (Connection con = DriverManager.getConnection(URL); Statement stmt = con.createStatement()) {

			// Relationale-Daten aus der DB abfragen
			ResultSet results = stmt.executeQuery("SELECT * FROM users");

			while (results.next()) {
				// Relationale-Daten in User-Objekte verpacken und in eine Liste ablegen
				User u = new User(results.getInt("id"), results.getString("firstname"), results.getString("lastname"));
				users.add(u);
			}
		}

		// Liste mit User-Objekten an den Aufrufer der find-Methode zurückgeben
		return users;
	}

	public User findById(int id) throws SQLException {

		try (Connection con = DriverManager.getConnection(URL); Statement stmt = con.createStatement()) {

			ResultSet results = stmt.executeQuery("SELECT * FROM users WHERE id = " + id);

			if (results.next()) {
				return new User(results.getInt("id"), results.getString("firstname"), results.getString("lastname"));
			}

			// TODO: statt NULL lieber ein Optional zurückgeben
			return null;
		}
	}
}
