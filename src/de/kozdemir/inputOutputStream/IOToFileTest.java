package de.kozdemir.inputOutputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOToFileTest {
	public static void main(String[] args) throws IOException {

		try {
			// CSV
			// 1, Hammer, 100, 19.99

			// textSchreiben();
			// textLesen();

			objecktSchreiben();
			objecktLesen();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		System.out.println("ENDE");

	}
	
	
	

	private void readFromFile() {
		List<Thing> things;
		final String FILE_NAME = "data.ser";
		try {
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(FILE_NAME)));
			things = (List<Thing>) in.readObject();
		} catch (Exception e) {
			// ... oder eine neue leere Liste gebaut
			things = new ArrayList<>();
		}
	}

	private void saveToFile() {
		List<Thing> things = null;
		final String FILE_NAME = "data.ser";

		try {
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(FILE_NAME)));
			out.writeObject(things);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	

	public static void objecktSchreiben() throws IOException {

		List<Thing> sachen = new ArrayList<>();
		sachen.add(new Thing("Banane", 1.00));
		sachen.add(new Thing("Apfel", 0.50));
		sachen.add(new Thing("Mango", 3.99));

		// OutputStream schreiben von Bytes
		// InputStream lesen von Bytes
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("objekt.ser"));

		// serialisiert = Objekte in Text übersetzen
		ObjectOutputStream objOut = new ObjectOutputStream(out); // Objekte werden au
		objOut.writeObject(sachen);// automatisch serialisiert und geschrieben
		objOut.flush();

	}

	public static void objecktLesen() throws IOException, ClassNotFoundException {
		BufferedInputStream in = new BufferedInputStream(new FileInputStream("objekt.ser"));
		ObjectInputStream objIn = new ObjectInputStream(in);
		List<Thing> t = (List<Thing>) objIn.readObject();
		System.out.println(t);
	}

	
	
	
	
	
	
	public static void textLesen() throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("text.txt"));
		String row = null;
		while ((row = in.readLine()) != null) {
			System.out.println(row);
		}
	}

	public static void textSchreiben() throws IOException {
		// OutputStream schreiben von Bytes
		// InputStream lesen von Bytes
		FileOutputStream fos = new FileOutputStream("text.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos); // Basiert auf dem FileOutputStream

		// Writer schreiben von Zeichen
		// Reader lesen von Zeichen

		// Ist die Datei beim Schreiben nicht verfügbar, wird es erstellt
		FileWriter fw = new FileWriter("text.txt", true);
		// fw.write("Hallo"); // Schreibt Zeichen für Zeichen
		BufferedWriter bw = new BufferedWriter(fw); // Basiert auf den FileWriter
		bw.write("Das ist ein text"); // schreibt mehrere Zeichen auf einen Schlag
		bw.newLine(); // Zeilenumbruch
		bw.flush(); // Schreibt den Inhalt des Puffers, auch wenn er noch nicht voll ist
	}
}