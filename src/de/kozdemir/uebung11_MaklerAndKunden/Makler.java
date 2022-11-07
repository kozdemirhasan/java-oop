package de.kozdemir.uebung11_MaklerAndKunden;

public class Makler extends Mitglied {
	
		
	public Makler(String mitgliedVorname, String mitgliedNachname, String telefonNumber, String mitgliedAlte) {
		super(mitgliedVorname, mitgliedNachname, telefonNumber, mitgliedAlte);
		
	}

	public void newImmobilieCreated() {
		
	}
	
	private String kontakt(Makler makler) {

		return "mit " + makler + " wurde kontaktieren";
	}

}
