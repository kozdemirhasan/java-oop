package de.kozdemir.uebung09_todolist;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class TodoManager {

	private Integer counter=0;
	private List<Todo> todoList;
	private final String FILE_NAME = "data.ser";
	private Todo todo;

	private final Scanner scanner = new Scanner(System.in);

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
			System.out.println("ungültige auswahl!!");

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
				System.out.println("wir arbeiten daran...");
				menu();
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
			todoList = new ArrayList<>();
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
		
		//Sortierung
		doSortierung();
		
		saveToFile();
		todoListPrint();
		menu();

	}



	private void todoListPrint() {
		System.out.println();
		if (todoList != null) {
			StringBuilder output = new StringBuilder();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

			output.append(String.format("%-3s   | %-40s  |  %-20s  |  %-10s  \n", "ID", "TITEL", "DATE", "STATUS"));
			output.append(String.format("%-20s \n",
					"--------------------------------------------------------------------------------------------------"));

			for (Todo t : todoList) {
				
//				??? Ternärer operator ????
//				todoList.forEach(x ->  {s. == true ?  "Erledigt": "Unerledigt"});				
				
				String status = "Unerledigt";
				if (t.isStatus())
					status = "Erledigt";

				output.append(String.format("%-4s  | %-40s  |  %-20s  |  %-10s  \n", t.getId(), t.getTitel(),
						t.getErzeugungsDate().format(myFormatObj), /* t.isStatus() */ status));
			}
			System.out.println(output);
		} else {
			System.out.println("Todolist ist leer!\n");		
		}
		menu();

	}

	public void readFromFile() {

		try {
			// InputStream lesen von Bytes
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(FILE_NAME)));			
//			ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME));			
			todoList = (List<Todo>) in.readObject();
			letzteIDFind();
			todoListPrint();
			in.close();
			menu();

		} catch (Exception e) {
			// eger dosyayi okuyamas ise (silinmis veya baska prb) ve todoList != null ise
			// todoList i dosyaya yaz
			// eger dosya okunamiyor ve todoList == null ise yeni todoList array erstellt
			if (todoList != null)
				saveToFile();
			else

				menu();
		}
	}

	private void saveToFile() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(FILE_NAME)));
//			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
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
					if (t.isStatus() == false)
						t.setStatus(true);
					else
						System.out.println(t.getTitel()+ " wurde schon erledigt!");
				}
			}
			
			doSortierung();
			saveToFile();
			todoListPrint();

		} else {
			System.out.println("Ungultige ID Nummer!");
			todoBearbeiten();

		}

	}

	private void doSortierung() {
		
//		Collections.sort(todoList, new TodoTitleComparator());
//		Collections.sort(todoList, new TodoErzeugungsDateComparator());
	
		Comparator<Todo> operatorTitel = (o1, o2) -> o1.getTitel().compareTo(o2.getTitel());
		Comparator<Todo> operatorDate = (o1, o2) -> o2.getErzeugungsDate().compareTo(o1.getErzeugungsDate());
		Comparator<Todo> operatorStaus = (o1, o2) -> o1.isStatus().compareTo(o2.isStatus());
		
		Collections.sort(todoList, operatorStaus); //erste Status
		Collections.sort(todoList, operatorTitel); //dann title
		Collections.sort(todoList, operatorDate); //dann Date sortiert
		
	}
	
	
//	//mit Erzeugungsdate sortiert
//	class TodoErzeugungsDateComparator implements Comparator<Todo> {
//
//		@Override
//		public int compare(Todo t1, Todo t2) {
////			return t1.getErzeugungsDate().compareTo(t2.getErzeugungsDate());
//			return t2.getErzeugungsDate().compareTo(t1.getErzeugungsDate());
//		}
//	}
//
//	//mit Title sortiert
//	class TodoTitleComparator implements Comparator<Todo> {
//
//		@Override
//		public int compare(Todo t1, Todo t2) {
//			return t1.getTitel().compareTo(t2.getTitel());
//		}
//	}

}