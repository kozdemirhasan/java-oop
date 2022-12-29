package de.kozdemir.patterns.structural.decorator.autoversicherung;

public class Unfallgeschichte extends Versicherung{

	public Unfallgeschichte(IVersicherung versicherung, String title, double preis) {
		super(versicherung, title, preis);
		
	}

}
