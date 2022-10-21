package de.kozdemir.uebung07;

import java.util.Random;
import java.util.Scanner;

public class Spiel {

	final private static Scanner scanner = new Scanner(System.in);
	private String[][] eingabeList;
	private String[][] randomZellen;

	private Spielbrett spielbrett;
	private int spielZahl = 1;
	private int gefunden;

	private final int CAPACITY;
	private final int VERMUTUNG_ZAHL;

	public Spiel(int capacity, int verzug) {
		
		CAPACITY = capacity;
		VERMUTUNG_ZAHL = verzug;

		eingabeList = new String[CAPACITY][CAPACITY];
		randomZellen = new String[CAPACITY][CAPACITY];
		spielbrett = new Spielbrett(CAPACITY, CAPACITY);

	}
	

	public void run() {
		spielEinbau();
		eingabe();
	}

	public void eingabe() {

//		try {

			// 10 mal versuchen
			while (spielZahl <= VERMUTUNG_ZAHL) {
				System.out.print("[Schätzung: " + spielZahl +"/"+ VERMUTUNG_ZAHL+"] ");

				System.out.print("Pos: (x,y): ");
				String[] koordinat = scanner.nextLine().trim().split(",");

				int x = 0;
				int y = 0;

				x = Integer.parseInt(koordinat[0]); // first String to int
				y = Integer.parseInt(koordinat[1]); // second String to int

				if ((x >= 1 && x <= CAPACITY) && (y >= 1 && y <= CAPACITY)) {
					if (controllEintritt((x - 1), (y - 1))) {
						System.out.println("(" + x + "," + y + ") wurde schon eingegeben!");
						eingabe();

					} else {
						spielZahl++;
						if (!vermutungControll(x - 1, y - 1)) {
							eingabeList[x - 1][y - 1] = "-";
						} else {
							eingabeList[x - 1][y - 1] = "X";
							gefunden++;
						}
						spielbrett.brettFuellen(eingabeList);
					}

				} else {
					System.out.println("Ungultige Koordinat!");
				}
			}

			// info nach dem Spiel
			if (gefunden > 0)
				System.out.println(gefunden + " richtige Vermutungen");
			else
				System.out.println("Leider, keine richtige Vermutung");

//		} catch (Exception ex) {
//			System.out.println("Ungultige eingabe!\n");
//			eingabe();
//
//		}

//		//Wieder spiel oder nict?
//		System.out.println("Möchtest du wieder spielen? (Spiel: S, Quit: Q)");
//		String s=scanner.next();
//		if(s.equals("S") || s.equals("s") ){
//			Spiel sp = new Spiel();
//			
//		}else if(s.equals("Q") || s.equals("q") ){ 
//			System.out.println("Spiel ende...");
//			System.exit(0);
//		}

	}

	public boolean controllEintritt(int x, int y) {
		boolean check = false;
		for (int i = 0; i < CAPACITY; i++) {
			for (int j = 0; j < CAPACITY; j++) {
				if (eingabeList[x][y] != null) {
					check = true;
					break;
				}
			}
		}
		return check;
	}

	public boolean vermutungControll(int x, int y) {
		boolean check = false;
		for (int i = 0; i < CAPACITY; i++) {
			for (int j = 0; j < CAPACITY; j++) {
				if (randomZellen[x][y] != null) {
					check = true;
					break;
				}
			}
		}
		return check;
	}

	public void spielEinbau() {
		// Random Coordinat werden erzeugt
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			int x = r.nextInt(CAPACITY);
			int y = r.nextInt(CAPACITY);
			randomZellen[x][y] = "?";
		}

	}

}
