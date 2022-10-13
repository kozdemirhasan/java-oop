package de.kozdemir.uebung02_wuerfelBecker.wuerfelBecker;

import java.util.Random;
import java.util.Scanner;


public class WuerfelSpiel {
	static  Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println('\65');

		int[] seiteUndSpielZalh = eingabe();
		int seiteZahl = seiteUndSpielZalh[0];
		int spielZahl = seiteUndSpielZalh[1];
		
		int[] ergebnis ;

		boolean ungultig = false;
		while (true) {
			if (ungultig == false) {
				 ergebnis = spiel(seiteZahl, spielZahl);
				toPrint(ergebnis, seiteZahl);
			}
//			System.out.println();

			System.out.println("\n[ENTER: Wieder spielen, N: Neue Spiel,  ESC: Exit]" );

			String w = sc.next();
		
			if (w.equalsIgnoreCase("x")) {
				System.out.println("Tschüss!!");
				System.exit(0);
			} else if (w.equalsIgnoreCase("s")) {
				ungultig = false;
				continue;
			} else {
				System.out.println("Ungültiger eingabe!");
				ungultig = true;
			}
		}

	}

	public static int[] eingabe() {
		int[] array = new int[2];

	

		int seiteZahl = 0;
		int spielZahl = 0;

		// Zahl der Würfelseiten
		while (true) {
			System.out.println("Seitenzahl des Würfels ein (oder \"x\" für Ende):");
			String eingabe = sc.next();
			if (eingabe.equalsIgnoreCase("x")) {
				System.out.println("Tschüss!!");
				System.exit(0);
			} else {
				try {
					seiteZahl = Integer.valueOf(eingabe);
					break;
				} catch (Exception e) {
					System.out.println("Ungültiger die Seitenzahl des Würfels!");
					continue;
				}
			}
		}

		while (true) {
			System.out.println("Zahl des Spieles ein (oder \"x\" für Ende):");
			String eingabe = sc.next();
			if (eingabe.equalsIgnoreCase("x")) {
				System.out.println("Tschüss!!");
				System.exit(0);
			} else {
				try {
					spielZahl = Integer.valueOf(eingabe);
					break;
				} catch (Exception e) {
					System.out.println("Ungültiger Wert der Spileszahl!");
					continue;
				}
			}
		}

		array[0] = seiteZahl;
		array[1] = spielZahl;

		

		return array;
	}

	public static int[] spiel(int seiteZahl, int spielZahl) {
		int[] erg = new int[spielZahl];
		Random r = new Random();
		for (int i = 0; i < spielZahl; i++) {
			erg[i] = r.nextInt(seiteZahl) + 1;
		}

		return erg;
	}

	// array print
	public static void toPrint(int[] ergebnis, int seiteZahl) {
		for (int x : ergebnis)
			System.out.print(x + " ");
		System.out.println();

		int[] countArray = new int[seiteZahl];
		for (int index = 0; index < countArray.length; index++) {
			countArray[index] = 0;
		}

		for (int e : ergebnis) {
			countArray[e - 1]++;
		}

		System.out.println();

		for (int i = 0; i < countArray.length; i++) {
			if (i != countArray.length - 1)
				System.out.print(countArray[i] + " mal " + (i + 1) + ", ");
			else
				System.out.print(countArray[i] + " mal " + (i + 1));
		}
		System.out.println();
	}

}