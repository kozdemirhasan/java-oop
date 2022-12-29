package de.kozdemir.patterns.structural.decorator.autoversicherung;

public class BesitzerAlter extends Versicherung {

	public BesitzerAlter(IVersicherung versicherung, String title, double preis) {
		super(versicherung, title, preis);
		
	}

}
