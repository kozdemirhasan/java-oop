package de.kozdemir.objects;

import java.util.Arrays;

public class SpielBrett {
	
	private final char[][] felder = new char[8][8];
	
	public SpielBrett() {
		for(char[] i : felder) {
			Arrays.fill(i, '.');
		}
	}
	
	public void setzeStein(int x, int y, Spieler s) {
		felder[x][y] = s.getKuerzel();
		zeigeBrett();
	}
	
	public void zeigeBrett() {
		synchronized (this) {
			for(char[] i : felder) {
				for(char j : i) {
					System.out.print(j + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
