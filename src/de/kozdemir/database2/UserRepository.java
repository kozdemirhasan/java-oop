package de.kozdemir.database2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


//CRUD: Create, Read, Update, Delete
//BREAD: Browse, Read, Edit, Add, Delete

public class UserRepository extends AbstractRepository<User> {
	
	public UserRepository() throws SQLException {
		super("users"); // Übergibt den Tabellennamen an AbstractRepository
		createTable(); // Tabelle wird, wenn sie noch nicht da ist, erzeugt
	}
	
	/**
	 * Speichert ein User-Objekt als Datensatz in der Datenbank. Die neu vergebene ID wird in das Objekt geschrieben
	 * @param u
	 * @return
	 * @throws SQLException
	 */
	protected boolean insert(User u) throws SQLException {
		
		final String SQL = "INSERT INTO " + TABLE + " (id, firstname, lastname) VALUES(null, ?, ?)";
		
		try(Connection con = DatabaseUtils.getConnection();
				PreparedStatement stmt = con.prepareStatement(SQL)) {
			
			// Werte die die Platzhalter ersetzen werden nicht mehr als Befehle interpretiert
			
			stmt.setString(1, u.getFirstname());
			stmt.setString(2, u.getLastname());
			
			if(stmt.executeUpdate() > 0) {
				
				// Abfrage der zuletzt vergebenen ID
				ResultSet keys = con.createStatement().executeQuery("SELECT last_insert_rowid()");
				if(keys.next()) {
					u.setId(keys.getInt("last_insert_rowid()"));
					return true;
				}
			}
			return false;
		}
	}
	
	/**
	 * Updatet einen User-Datensatz in der Datenbank
	 * @param u
	 * @return
	 * @throws SQLException
	 */
	protected boolean update(User u) throws SQLException {
		
		final String SQL = "UPDATE " + TABLE + " SET firstname = ?, lastname = ? WHERE id = ?";

		try(Connection con = DatabaseUtils.getConnection();
				PreparedStatement stmt = con.prepareStatement(SQL)) {
			
			stmt.setString(1, u.getFirstname());
			stmt.setString(2, u.getLastname());
			stmt.setInt(3, u.getId());
			
			return stmt.executeUpdate() > 0;
		}
		
	}
	
	
	/**
	 * Mappt ein ResultSet auf ein User-Objekt ab
	 * @param result
	 * @return
	 * @throws SQLException
	 */
	protected User create(ResultSet result) throws SQLException {
		return new User(result.getInt("id"), result.getString("firstname"), result.getString("lastname"));
	}
	
	
	protected void createTable() throws SQLException {
		
		final String SQL = "CREATE TABLE IF NOT EXISTS " + TABLE + " ("
						 		+ "id INTEGER, "
						 		+ "firstname TEXT NOT NULL, "
						 		+ "lastname TEXT NOT NULL, "
						 		+ "PRIMARY KEY(id AUTOINCREMENT)"
						 + ")";
		
		try(Connection con = DatabaseUtils.getConnection();
				Statement stmt = con.createStatement()) {
			
			// execute führt eine beliebige Anweisung aus
			stmt.execute(SQL);
		}
	}


}
