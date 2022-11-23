package de.kozdemir.database2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public abstract class AbstractRepository<T extends AbstractEntity> implements Repository<T> {

	protected final String TABLE;
	
	public AbstractRepository(String tbl) {
		TABLE = tbl;
	}
	
	public boolean save(T t) throws SQLException {
		
		if(t.getId() > 0) {
			return update(t);
		}
		
		return insert(t);
	}
	
	
	protected abstract boolean insert(T t) throws SQLException;
		
	protected abstract boolean update(T t) throws SQLException;
	
	
	public boolean delete(T t) throws SQLException {
		return delete(t.getId());
	}
	
	public boolean delete(int id) throws SQLException {
		
		final String SQL = "DELETE FROM " + TABLE + " WHERE id = " + id;
		
		try(Connection con = DatabaseUtils.getConnection();
				Statement stmt = con.createStatement()) {
			
			// executeUpdate liefert die Anzahl betroffener Datensätze
			return stmt.executeUpdate(SQL) > 0;
		}
	}
	
	public List<T> find() throws SQLException {
		
		final String SQL = "SELECT * FROM " + TABLE;
		
		List<T> objects = new ArrayList<>();
		
		// Verbindung zur DB aufbauen
		try(Connection con = DatabaseUtils.getConnection();
				Statement stmt = con.createStatement()) {
			
			// Relationale-Daten aus der DB abfragen
			ResultSet results = stmt.executeQuery(SQL);
			
			while(results.next()) {
				// Relationale-Daten in User-Objekte verpacken und in eine Liste ablegen
				objects.add(create(results));
			}
		}
		
		// Liste mit User-Objekten an den Aufrufer der find-Methode zurückgeben
		return objects;
	}
	
	public T findById(int id) throws SQLException {
		
		final String SQL = "SELECT * FROM " + TABLE + " WHERE id = " + id;
		
		try(Connection con = DatabaseUtils.getConnection();
				Statement stmt = con.createStatement()) {
			
			// executeQuery liefert immer ein ResultSet zurück
			ResultSet results = stmt.executeQuery(SQL);
			
			if(results.next()) {
				return create(results);
			}
			
			// TODO: statt NULL lieber ein Optional zurückgeben
			return null;
		}
	}
	
	protected abstract T create(ResultSet result) throws SQLException;
	
	protected abstract void createTable() throws SQLException;

}