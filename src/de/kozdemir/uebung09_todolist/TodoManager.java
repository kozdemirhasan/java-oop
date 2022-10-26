package de.kozdemir.uebung09_todolist;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class TodoManager {

	private int counter;
	private String benutzerName = "";
	private Set<Todo> todoList;
	private final String FILE_NAME = "data.ser";
	private Todo todo;

	private final Scanner scanner = new Scanner(System.in);

//	public TodoManager(String benutzerName) {
//		this.benutzerName = benutzerName;
//
//		readFromFile();
//
//	}
	public TodoManager() {
		readFromFile();

	}

	private void menu() {

		System.out.println(" _______________________________________");
		System.out.println("|                MENU                   |");
		System.out.println("|---------------------------------------|");
		System.out.println("|   1- Aufgabe erstellen                |");
		System.out.println("|   2- Aufgabenliste                    |");
		System.out.println("|   3- Aufgabe bearbeiten               |");
		System.out.println("|   4- Hilfe                            |");
		System.out.println("|   5- Exit                             |");
		System.out.println("|_______________________________________|");

		int wahl = 0;
		System.out.print("\nAuswahl: ");
		try {
			wahl = scanner.nextInt();
		} catch (Exception e) {
			scanner.nextLine();
			System.out.println("ungültige auswahl!");

			menu();

		}

		if (wahl >= 1 && wahl <= 5) {

			switch (wahl) {
			case 1:
				neueAufgabe();
				break;
			case 2:
				todoListPrint();
				break;
			case 3:
				todoBearbeiten();

				break;
			case 4:
				System.out.println("derzeit im Bau...");
				break;

			case 5:
				System.out.println("Programmende...");
				System.exit(0);
				break;

			}

		} else {
			System.out.println("ungültige auswahl!");
		}

	}

	private void neueAufgabe() {

		if (todoList == null) {
			todoList = new TreeSet<>();
		}

		todo = new Todo();

		todo.setId(++counter);
		scanner.nextLine(); // fix
		while (true) {
			System.out.print("Titel: ");

			String eingabe = scanner.nextLine();
			if (!eingabe.equals("")) {
				todo.setTitel(eingabe);
				break;
			}

			else {
				System.out.println("Aufgabe kann nicht leer sein!!");
			}

		}

		LocalDateTime erzeugungsDatum = LocalDateTime.now();
		todo.setErzeugungsDate(erzeugungsDatum);

		todo.setStatus(false); // false = Unerledigt

		todoList.add(todo);

		saveToFile();
		todoListPrint();
		menu();

	}

	private void todoListPrint() {
		System.out.println();
		if (todoList != null) {
//			System.out.println("\n\n[Benutzer: " + benutzerName.toUpperCase() + "]");

			StringBuilder output = new StringBuilder();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

			output.append(String.format("%-3s   | %-40s  |  %-20s  |  %-10s  \n", "ID", "TITEL", "DATE", "STATUS"));
			output.append(String.format("%-20s \n",
					"--------------------------------------------------------------------------------------------------"));

			for (Todo t : todoList) {
				String status = "Unerledigt";
				if (t.isStatus())
					status = "Erledigt";

				output.append(String.format("%-4s  | %-40s  |  %-20s  |  %-10s  \n", t.getId(), t.getTitel(),
						t.getErzeugungsDate().format(myFormatObj), /* t.isStatus() */ status));
			}
			System.out.println(output);

			menu();

		} else {
			System.out.println("Todolist ist leer!\n");
			menu();
		}

	}

	private void readFromFile() {

		try {
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(FILE_NAME)));
			todoList = (Set<Todo>) in.readObject();
			letzteIDFind();
			todoListPrint();
			menu();

		} catch (Exception e) {
			// eger dosyayi okuyamas ise (silinmis veya baska prb) ve todoList != null ise
			// todoList i dosyaya yaz
			// eger dosya okunamiyor ve todoList == null ise yeni todoList array erstellt
			if (todoList != null)
				saveToFile();
			else
				// todoList = new TreeSet<>();

				menu();
		}
	}

	private void saveToFile() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(FILE_NAME)));
			out.writeObject(todoList);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void letzteIDFind() {
		for (Todo t : todoList) {
			if (t.getId() > counter) {
				counter = t.getId();

			}
		}
		saveToFile();

	}

	private void todoBearbeiten() {
		System.out.print("Geben Sie ID Nummer von Todo: ");
		int idNum = -1;
		try {
			scanner.nextLine();
			idNum = scanner.nextInt();
		} catch (Exception e) {
			// e.printStackTrace();
		}

		if (idNum >= 1 && idNum <= counter) {
			for (Todo t : todoList) {
				if (t.getId() == idNum) {
					if (t.isStatus() == true)
						t.setStatus(false);
					else
						t.setStatus(true);
				}
			}

			saveToFile();
			todoListPrint();

		} else {
			System.out.println("Ungultige ID Nummer!");
			todoBearbeiten();

		}

	}

//	public void neuenBenutzer() {
//
//		System.out.print("Geben Sie Benutzername: ");
//		String benutzerName = scanner.nextLine();
//		TodoManager tm1 = new TodoManager(benutzerName);
//	}

}