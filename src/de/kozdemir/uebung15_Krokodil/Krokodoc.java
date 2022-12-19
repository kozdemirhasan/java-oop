package de.kozdemir.uebung15_Krokodil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Krokodoc {

	private final Scanner scan = new Scanner(System.in);

	private List<Integer> gezogeneZahne;



	public Krokodoc() {
		setEntzuendetZahn();
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
		gezogeneZahne = new ArrayList<>();

		while (true) {

			for (int i = 0; i < spielers.length; i++) {
				System.out.print(spielers[i].spilerName + " :");
				int s = scan.nextInt();

				if (s > 0 && s < 33) {
					if (s == entzuendetZahn) {
						System.out.println(entzuendetZahn + ". Zahn ist entzüdente Zahn. " + spielers[i].spilerName
								+ " hat das Spiel verloren.\n\n[ENDE]");
						System.exit(0);
					} else {
						if (controll(s)) {
							System.out.println(s + ". Zahn bereit gezogen\n");
							--i;
						} else {
							System.out.println("Super. " + s + ". Zahn wurde gezogen");
							gezogeneZahne.add(s);
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
		for (Integer s : gezogeneZahne) {
			if (s == i)
				return true;
		}
		return false;
	}

	public void printZaehne() {
		System.out.print("Zähne: ");
		for (String str : zaehne)
			System.out.printf("[%2s]  ", str);

		System.out.println("\n");
	}
}
