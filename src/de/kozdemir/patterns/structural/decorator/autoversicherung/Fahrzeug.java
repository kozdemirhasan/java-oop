package de.kozdemir.patterns.structural.decorator.autoversicherung;

public class Fahrzeug  {
	private String schild;
	private int erselltJahr;
	private String motorCode;
	private String fahrgestellnummer;
	private String farbe;
	private Zusatzausstattung zusatzausstattung;
	
	public Fahrzeug(String schild, int erselltJahr, String motorCode, String fahrgestellnummer, String farbe,
			Zusatzausstattung zusatzausstattung) {
		this.schild = schild;
		this.erselltJahr = erselltJahr;
		this.motorCode = motorCode;
		this.fahrgestellnummer = fahrgestellnummer;
		this.farbe = farbe;
		this.zusatzausstattung = zusatzausstattung;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[schild=");
		builder.append(schild);
		builder.append(", erselltJahr=");
		builder.append(erselltJahr);
		builder.append(", motorCode=");
		builder.append(motorCode);
		builder.append(", fahrgestellnummer=");
		builder.append(fahrgestellnummer);
		builder.append(", farbe=");
		builder.append(farbe);
		builder.append(", zusatzausstattung=");
		builder.append(zusatzausstattung);
		builder.append("]");
		return builder.toString();
	}
	
	

}
