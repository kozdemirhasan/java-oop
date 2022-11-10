package de.kozdemir.uebung11_MaklerAndKunden;

public class Mitglied {
	
	private String vorname;
	private String nachname;
	private String telefonNumber;
	private String mitgliedAlte;
	
	public Mitglied(String vorname, String nachname, String telefonNumber, String mitgliedAlte) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.telefonNumber = telefonNumber;
		this.mitgliedAlte = mitgliedAlte;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mitglied [mitgliedVorname=").append(vorname).append(", mitgliedNachname=")
				.append(nachname).append(", telefonNumber=").append(telefonNumber).append(", mitgliedAlte=")
				.append(mitgliedAlte).append("]");
		return builder.toString();
	}
		

}
