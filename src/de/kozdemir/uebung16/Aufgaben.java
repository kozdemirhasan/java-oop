package de.kozdemir.uebung16;

public enum Aufgaben {
	
	BEWEGUNG(0), BEGRUESSUNG(1), BUEGELN(2), WASCHEN(3), STAUBSAUGEN(4), AUFLADEN(5); 
	
	private int wahl;
	
	private Aufgaben(int wahl) {
		this.wahl= wahl;
	}
	
	public int getWahl() {
		return wahl;
	}
	

}
