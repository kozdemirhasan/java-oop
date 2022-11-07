package de.kozdemir.uebung11_MaklerAndKunden;

public class Kunden extends Mitglied{

	
	public Kunden(String mitgliedVorname, String mitgliedNachname, String telefonNumber, String mitgliedAlte) {
		super(mitgliedVorname, mitgliedNachname, telefonNumber, mitgliedAlte);
	}

	private void suchen() {

	}

	private void bewerten() {

	}

	private String kontakt(Makler makler) {

		return "mit " + makler + " wurde kontaktieren";
	}

}
