package de.kozdemir.uebung15_Krokodil_copy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Krokodoc {

	private final Scanner scan = new Scanner(System.in);
	private int entzuendetZahn;
	private List<Integer> schaetzens;

	private String[] zaehne = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
			"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32" };

	public Krokodoc() {
		setEntzuendetZahn();
	}

	public void entfernt(int index) {
		zaehne[index] = "__";
	}

	public String[] getZaehne() {
		return zaehne;
	}

	public int getEntzuendetZahn() {
		return entzuendetZahn;
	}

	public void setEntzuendetZahn() {
		this.entzuendetZahn = (int) (Math.random() * 32) + 1;
	}


	public void run() {

		// enter spilers
		System.out.print("Enter the number of players:");
		int numberOfplayers = scan.nextInt();

		Spieler[] spielers = new Spieler[numberOfplayers];

		for (int i = 0; i < numberOfplayers; i++) {
			System.out.print((i + 1) + ". player name: ");
			String playerName = scan.next();
			spielers[i] = new Spieler(playerName.toUpperCase());
		}
		System.out.println();

		play(spielers);

	}

	private void play(Spieler[] spielers) {

//		System.out.println(entzuendetZahn);
		schaetzens = new ArrayList<>();		
	
		while (true) {

			for (int i = 0; i < spielers.length; i++) {
				System.out.print("Dr. "+ spielers[i].spilerName + " :");
				int s = scan.nextInt();
				
				if (s > 0 && s < 33) {
					if (s == entzuendetZahn) {
						System.out
								.println(entzuendetZahn + ". Zahn ist entzüdente Zahn. " + spielers[i].spilerName + " hat das Spiel verloren.\n\n[ENDE]");						
						System.exit(0);
					} else {
						if(controll(s) ) {
							System.out.println(s+ ". Zahn bereit gezogen\n");
							--i;
						}else {
							System.out.println("Super. " + s + ". Zahn wurde gezogen");
							schaetzens.add(s);
							entfernt(s - 1);
							printZaehne();
						}						
					}
				} else {
					System.out.println("Ungültige Zahl von Zahn\n");
					--i;
				}
			}

			
		}

	}

	private boolean controll(int i) {
		for (Integer s : schaetzens) {
			if (s == i)
				return true;
		}
		return false;
	}

	public void printZaehne() {
		System.out.print("Zähne: ");
		for (String str : zaehne)
			System.out.printf("[%s] ", str);
		
		System.out.println("\n");
	}
}
