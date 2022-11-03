package de.kozdemir.uebung10_scout;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;

public class ScoutManager {

	private static final Scanner scanner = new Scanner(System.in);
	private Set<Scout> scoutsList;

	public static void main(String[] args) {

		ScoutManager sm = new ScoutManager();
		
		sm.addScout();

		sm.printScouts();

	}


	public void addScout() {
		// new ArrayList erstellt
		if (scoutsList == null)
			scoutsList = new HashSet<>();

		while (true) {
			Scout newScout = new Scout();
			System.out.println("Neu Scout erstellen:");

			// Vorname
			System.out.print("Vorname:");
			scanner.next();
			String vorName = scanner.nextLine();
			newScout.setFirstName(vorName);

			// Lastname
			System.out.print("Lastname:");
			String lastName = scanner.nextLine();
			newScout.setLastName(lastName);

			// Gebusttag
			System.out.print("Gebursttag (z.B: 23/10/1998):");
			String gebursttag[] = scanner.nextLine().split("/");
//			System.out.println("" +Integer.parseInt(gebursttag[2])+"/"+ Integer.parseInt(gebursttag[1])+"/" +
//			Integer.parseInt(gebursttag[0]));				
			newScout.setBirthDate(LocalDate.of(Integer.parseInt(gebursttag[2]), Integer.parseInt(gebursttag[1]),
					Integer.parseInt(gebursttag[0])));

			// Height
			System.out.println("Height:");
			int name = scanner.nextInt();
			newScout.setHeight(name);

			try {
				scoutsList.add(newScout);
			} catch (Exception e) {
				System.out.println("Ekleme hatasi...");
			}

			while (true) {
				// wieder neue Scout erstellt oder?
				System.out.println("\nMöchten Sie neue Scout erstellen?\n" + "[N: Neue Scout erstellt, Q: Exit]");
				if (scanner.next().equalsIgnoreCase("q")) {
					break;
				} else if (scanner.next().equalsIgnoreCase("n")) {
					addScout();

				} else {
					System.err.println("Ungültiger Auswahl!");
					continue;
				}
			}

		}

	}

	public void printScouts() {

		for (Scout s : scoutsList) {
			System.out.println(
					s.getFirstName() + " " + s.getLastName() + " " + s.getBirthDate().toString() + " " + s.getHeight());
		}

	}

//	public void ersteVersion() {
//		Scout s1 = new Scout("Peter", "Parker", LocalDate.of(1998, 5, 15), 182);
//		Scout s2 = new Scout("Carol", "Danvers", LocalDate.of(2000, 7, 2), 177);
//		Scout s3 = new Scout("Bruce", "Banner", LocalDate.of(1982, 12, 1), 200);
//		Scout s4 = new Scout("Natasha", "Romanov", LocalDate.of(1998, 1, 2), 175);
//		Scout s5 = new Scout("Steve", "Taylor", LocalDate.of(1987, 5, 9), 179);
//
//		List<Scout> scoutsList = new ArrayList<>();
//		scoutsList.add(s1);
//		scoutsList.add(s2);
//		scoutsList.add(s3);
//		scoutsList.add(s4);
//		scoutsList.add(s5);
//
//		Comparator<Scout> sortFirstName = (scout1, scout2) -> scout1.getFirstName().compareTo(scout2.getFirstName());
//		Comparator<Scout> sortLastName = (scout1, scout2) -> scout1.getLastName().compareTo(scout2.getLastName());
//
//		Collections.sort(scoutsList, sortFirstName.thenComparing(sortLastName));
//
//		for (Scout s : scoutsList) {
//			System.out.println(s.getFirstName() + " " + s.getLastName());
//		}
//	}

}
