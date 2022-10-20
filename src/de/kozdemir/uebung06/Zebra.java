package de.kozdemir.uebung06;

// Zebra IS-A Tier
public class Zebra extends Tier {

	public Zebra(String name) {
		super(name);
	}

	@Override
	public void frisst() {
		// name ist privat in der Tier-Klasse, daher muss der public Getter verwendet werden
		System.out.println(getName() + " frisst Salat.");
	}

	@Override
	public void pennt() {
		System.out.println(getName() + " schläft die ganze Nacht.");
		
	}
}
