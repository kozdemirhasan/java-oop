package de.kozdemir.patterns.structural.decorator.autoversicherung;

import java.util.ArrayList;
import java.util.List;


public class BasisVersicherung implements IVersicherung{

	private String name;
	private double preis;
	
	
	public BasisVersicherung(String name, double preis) {
		this.name = name;
		this.preis = preis;
	}

	@Override
	public double calculatePreis() {
		return preis;
	}

	@Override
	public List<Versicherung> getVersicherung() {		
		return  new ArrayList<Versicherung>();
	}


	


}
