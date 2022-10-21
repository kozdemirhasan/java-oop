package de.kozdemir.uebung07;

public class Spielbrett {

	private String[][] feld;

	public Spielbrett(int x, int y) {
		feld = new String[x][y];

	}

	public void brettFuellen(String[][] eingabeList) {
		System.out.println();
		// füllen
		for (int x = 0; x < feld.length; x++) {
			for (int y = 0; y < feld[x].length; y++) {

				if (eingabeList[x][y] != null) {

					if (eingabeList[x] [y].equals("X")) {
						feld[x][y] = "  X  ";
					} else if (eingabeList[x][y].equals("-")) {
						feld[x][y] = "  O  ";
					}

				} else {
					feld[x][y] = "  #  ";
				}
			}
		}

		System.out.print("   ");
		
		for(int i=1; i<=feld.length; i++) {
			if(i<10) {
				System.out.print("  X"+i+" ");
			}
			else {
				System.out.print("  X"+i);
			}
			
		}
		System.out.println();
		
		for (int y = 0; y < feld.length; y++) {

			if (y > 8)
				System.out.print("Y" + (y + 1) + " ");
			else
				System.out.print(" Y" + (y + 1) + " ");

			for (int x = 0; x < feld[y].length; x++) {
				System.out.print(feld[x][y]);
			}
			System.out.println("\n");
		}
		System.out.println();

	}

}
