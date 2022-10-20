package de.kozdemir.uebung07;

public class Spielbrett {

	private String[][] feld;

	public Spielbrett(int x, int y) {
		feld = new String[x][y];
	}

	public void brettFuellen(String[][] eingabeList) {

		// füllen
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {

				if (eingabeList[x][y] != null) {

					if (eingabeList[x][y].equals("X")) {
						feld[x][y] = "X";
					} else if (eingabeList[x][y].equals("-")) {
						feld[x][y] = "-";
					}

				}else {
					feld[x][y] = ".";
				}
			}
		}

		for (int x = 0; x < feld.length; x++) {
			for (int y = 0; y < feld[x].length; y++) {
				System.out.print(feld[x][y]);
			}
			System.out.println();
		}
		System.out.println();

	}

}
