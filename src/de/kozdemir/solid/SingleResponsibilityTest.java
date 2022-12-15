package de.kozdemir.solid;

import java.util.ArrayList;
import java.util.List;

public class SingleResponsibilityTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

//class StromZaehler {
//	
//	public void printVerbrauch() {
//	}
//	
//	public void berechneVerbrauch() {
//	}
//	
//	public String getDetails() {
//	}
//	
//	public void anderenZaelhlerHinzufuegen() {
//	}
//}

class StromZaehler {
	
	private StromZaehlerPrinter printer;
	
	private StromZaehlerDetails details;
	
	public StromZaehler(StromZaehlerPrinter printer, StromZaehlerDetails details) {
		this.printer = printer;
		this.details = details;
	}

	public void berechneVerbrauch() {
	}
}

class StromZaehlerPrinter {
	
	public void printVerbrauch() {
	}
}

class StromZaehlerDetails {
	
	public String getDetails() {
		return "";
	}
}

class StromZaehlerGruppe {
	
	private List<StromZaehler> zaehler = new ArrayList<>();
	
	public void add(StromZaehler z) {
		zaehler.add(z);
	}
}

