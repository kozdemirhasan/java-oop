package de.kozdemir.patterns.builder;

public class Fahrzeug {
	
	private final String marke;
	private final String typ;
	private final String farbe;
	
	private String kenzeichen;
	
	
	public Fahrzeug(String marke, String typ, String kenzeichen, String farbe) {
		this.marke = marke;
		this.typ = typ;
		this.kenzeichen = kenzeichen;
		this.farbe = farbe;
	}


	public void setKenzeichen(String kenzeichen) {
		this.kenzeichen = kenzeichen;
	}

	public String getMarke() {
		return marke;
	}

	public String getTyp() {
		return typ;
	}

	public String getFarbe() {
		return farbe;
	}

	public String getKenzeichen() {
		return kenzeichen;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Fahrzeug [marke=").append(marke).append(", typ=").append(typ).append(", farbe=").append(farbe)
				.append(", kenzeichen=").append(kenzeichen).append("]");
		return builder.toString();
	}
	
	
}
