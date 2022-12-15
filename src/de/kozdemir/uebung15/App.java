package de.kozdemir.uebung15;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

	private final Scanner scan = new Scanner(System.in);
	Krokodoc k;
	List<Integer> schaetzens;

	public static void main(String[] args) {

		new App().run();

	}

	private void run() {

		// enter spilers
		System.out.print("Enter the number of players:");
		int numberOfplayers = scan.nextInt();

		Spieler[] spielers = new Spieler[numberOfplayers];

		for (int i = 0; i < numberOfplayers; i++) {
			System.out.print((i + 1) + ". player name: ");
			String playerName = scan.next();
			spielers[i] = new Spieler(playerName);
		}
		System.out.println();

		play(spielers);

	}

	private void play(Spieler[] spielers) {

		k = new Krokodoc();
		int entzuendetZahn = k.entzuendetZahn();
		//System.out.println(entzuendetZahn);

		schaetzens = new ArrayList<>();		
	
		while (true) {

			for (int i = 0; i < spielers.length; i++) {
				System.out.print(spielers[i].spilerName + " :");
				int s = scan.nextInt();
				
				if (s > 0 && s < 33) {
					if (s == entzuendetZahn) {
						System.out
								.println(entzuendetZahn + " ist entzüdente Zahn. " + spielers[i].spilerName + " hat das Spiel verloren.\n\n[ENDE]");
						
						System.exit(0);
					} else {
						if(controll(s) ) {
							System.out.println(s+ ". Zahn wurde vorher gezogen\n");
							--i;
						}else {
							schaetzens.add(s);
							k.entfernt(s - 1);
							k.printZaehne();
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

}
