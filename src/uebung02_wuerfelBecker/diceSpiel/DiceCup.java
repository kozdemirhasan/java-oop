package uebung02_wuerfelBecker.diceSpiel;

import java.util.Random;

/**
 * Würfelbecher
 * @author kozdemirhasan
 *
 */
public class DiceCup {
	

	private Random rand = new Random(); // Zufallsgenerator
	
	private int size = 6; // 6-Seite ist der Standard
	
	public DiceCup(int size) {
		this.size = size;
	}

	public DiceCup() {
	}

	/**
	 * Simuliert einen Würfelwurf
	 * @return
	 */
	public int roll() {
		return rand.nextInt(size) + 1;
	}
	
	/**
	 * Simuliert mehrere Würfelwürfe
	 * @param num Anzahl gewÃnschter WÃ¼rfe
	 * @return
	 */
	public int[] roll(int num) {
		int[] results = new int[num];
		
		for (int i = 0; i < results.length; i++) {
			results[i] = roll();
		}
		
		return results;
		
	}
	
	/**
	 * Ausgabe einer Statistik fÃ¼r WÃ¼rfelwÃ¼rfe
	 * @param results Array mit WÃ¼rfelwÃ¼rfen
	 * @return
	 */
	public String stats(int[] results) {
		
		int[] statistics = new int[size];
		
		for (int i = 0; i < results.length; i++) {
			int index = results[i] - 1;
			statistics[index]++;
		}
		
		String output = "";
		
		for (int i = 0; i < statistics.length; i++) {
			output += statistics[i] + " mal " + (i + 1) + "\n";
		}
		
		return output;
	}
}
