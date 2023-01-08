package de.kozdemir.objects;

import java.util.Random;

public class Spieler {

	private String name;
	
	private SpielBrett spielbrett;
	
	private Random rand = new Random();

	public Spieler(String name, SpielBrett spielbrett) {
		this.name = name;
		this.spielbrett = spielbrett;
	}
	
	public char getKuerzel() {
		return name.toUpperCase().charAt(0);
	}
	
	public void setzStein() {
		int x = rand.nextInt(8);
		int y = rand.nextInt(8);
		spielbrett.setzeStein(x, y, this);
	}
}
