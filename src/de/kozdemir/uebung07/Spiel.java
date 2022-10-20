package de.kozdemir.uebung07;

import java.util.Random;
import java.util.Scanner;

public class Spiel {

	final private static Scanner scanner = new Scanner(System.in);
	private String[][] eingabeList;
	private String[][] randomZellen;

	private static final int X_CAPACITY = 10;
	private static final int Y_CAPACITY = 10;

	private Spielbrett spielbrett;

	public Spiel() {
		eingabeList = new String[10][10]; // 10 defa tahmin edecek
		randomZellen = new String[10][10]; // 10 alana random atama yapildi

		spielbrett = new Spielbrett(X_CAPACITY, Y_CAPACITY);
	
		spielEinbau();
		eingabe();

	}

	public void eingabe() {

		// 10 mal versuchen
		for (int count = 1; count <= 10; count++) {

			System.out.println("Count: " + count);

			System.out.print("Koordinat (x,y): ");
			String[] koordinat = scanner.nextLine().trim().split(",");

			int x = 0;
			int y = 0;

//			try {
				x = Integer.parseInt(koordinat[0]); // first String to int
				y = Integer.parseInt(koordinat[1]); // second String to int

				if ((x >= 1 && x <= 10) && (y >= 0 && y <= 11)) {
					if (controllEintritt((x - 1), (y - 1))) {
						System.out.println("(" + x + "," + y + ") daha önce girildi!");
						eingabe();

					} else {

						if (!vermutungControll(x, y)) {
							eingabeList[x][y] = "-";
						} else {
							eingabeList[x][y] = "X";
						}
						spielbrett.brettFuellen(eingabeList);
					}

				} else {
					System.out.println("Ungultige Koordinat!");
				}
//
//			} catch (Exception ex) {
//				System.out.println("Ungultige eingabe!");
//
//			}
			
			
		}

	}

	public boolean controllEintritt(int x, int y) {
		boolean check = false;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
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
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
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
			int x = r.nextInt(10);
			int y = r.nextInt(10);
			randomZellen[x][y] = "?";
		}

	}

}
