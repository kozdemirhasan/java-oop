package de.kozdemir.uebung07;

public class Spielbrett {

	private String[][] feld;
	private int x;
	private int y;

	public Spielbrett(int x, int y) {
		feld = new String[x][y];
		this.x=x;
		this.y=y;
	}

	public void brettFuellen(String[][] eingabeList) {
		System.out.println();
		// füllen
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {

				if (eingabeList[x][y] != null) {

					if (eingabeList[x][y].equals("X")) {
						feld[x][y] = " X ";
					} else if (eingabeList[x][y].equals("-")) {
						feld[x][y] = " O ";
					}

				} else {
					feld[x][y] = " # ";
				}
			}
		}

		for (int x = 0; x < feld.length; x++) {
			for (int y = 0; y < feld[x].length; y++) {
				System.out.print(feld[y][x]);
			}
			System.out.println();
		}
		System.out.println();

	}

}
