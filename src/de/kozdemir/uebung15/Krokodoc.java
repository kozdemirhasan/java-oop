package de.kozdemir.uebung15;

public class Krokodoc {

	private int entzuendetZahn;

	private String[] zaehne = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
			"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32" };

	public Krokodoc() {
		setEntzuendetZahn();
	}

	public int entzuendetZahn() {

		return (int) (Math.random() * 32) + 1;
	}

	public void entfernt(int index) {

		zaehne[index] = "X";

	}

	public String[] getZaehne() {
		return zaehne;
	}

	public int getEntzuendetZahn() {
		return entzuendetZahn;
	}

	public void setEntzuendetZahn() {
		this.entzuendetZahn = (int) (Math.random() * 32) + 1;
	}

	public void printZaehne() {
		System.out.print("Zähne: ");
		for (String str : zaehne)
			System.out.printf("[%3s] ", str);
		
		System.out.println();
		System.out.println();
	}

}
