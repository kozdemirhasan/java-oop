package de.kozdemir.database2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtils {

	// Ablage im myapp-Verzeichnis im Benutzerverzeichnis
		public static final String HOME_DIR = System.getProperty("user.home") + "/myapp";		
		
		private static final String URL = "jdbc:sqlite:" + HOME_DIR + "/data.db";
		
		static {
			// NIO
			Path dir = Paths.get(HOME_DIR);
			try {
				if(Files.notExists(dir)) { // Wenn myapp Ordner nicht da ist
					Files.createDirectory(dir); // muss er erzeugt werden
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		private DatabaseUtils() {
		}
		
		public static Connection getConnection() throws SQLException {
			return DriverManager.getConnection(URL);
		}
	}
