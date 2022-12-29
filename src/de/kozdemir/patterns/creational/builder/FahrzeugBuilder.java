package de.kozdemir.patterns.creational.builder;

public class FahrzeugBuilder {
	
	private String marke;
	private String typ;
	private String kenzeichen;
	private String farbe;
	
	public String getMarke() {
		return marke;
	}
	public FahrzeugBuilder setMarke(String marke) {
		this.marke = marke;
		return this;
	}
	public String getTyp() {
		return typ;
	}
	public FahrzeugBuilder setTyp(String typ) {
		this.typ = typ;
		return this;
	}
	public String getKenzeichen() {
		return kenzeichen;
	}
	public FahrzeugBuilder setKenzeichen(String kenzeichen) {
		this.kenzeichen = kenzeichen;
		return this;
	}
	public String getFarbe() {
		return farbe;
	}
	public FahrzeugBuilder setFarbe(String farbe) {
		this.farbe = farbe;
		return this;
	}
	
	//***
	public Fahrzeug build() {
		return new Fahrzeug(marke, typ, kenzeichen, farbe);
	}

}
