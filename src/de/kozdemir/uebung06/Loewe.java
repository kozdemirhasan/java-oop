package de.kozdemir.uebung06;

//Loewe IS-A Tier
public class Loewe extends Tier {

	public Loewe(String name) {
		super(name);
	}

	// Hier wird beschrieben, WIE etwas eingebaut wurde
	@Override
	public void frisst() {
		System.out.println(getName() + " frisst Fleisch.");
		
	}

	// Hier wird beschrieben, WIE etwas eingebaut wurde
	@Override
	public void pennt() {
		System.out.println(getName() + " schläft nicht! Ist Jagd-Zeit.");
	}
}
