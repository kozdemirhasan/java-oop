package uebung03_robot;

public class Spielfeld {

	private String[][] feld;
	private int x;
	private int y;

	public Spielfeld(int xMax, int yMax) {
		feld = new String[xMax][yMax];
	}
//5 3
	public void fuellen(int k, int l) {
		// füllen
		for (int x = 0; x < feld.length; x++) {
			for (int y = 0; y < feld[x].length; y++) {
				if (x == k && y == l)
					feld[x][y] = "@";
				else
					feld[x][y] = ".";

			}
		}

		// print
		for (int x = 0; x < feld.length; x++) {
			for (int y = 0; y < feld[x].length; y++) {
				System.out.print(feld[y][x]);
			}
			System.out.println();
		}

	}

}

/*
 * public class Spielfeld {
 * 
 * private String feld = ""; public int x; public int y;
 * 
 * public Spielfeld() { }
 * 
 * public String getFeld() { return feld; }
 * 
 * public void setFeld(int x, int y) { feld = ""; for (int fy = 0; fy < 20;
 * fy++) { x: for (int fx = 0; fx < 20; fx++) { if (fx == x && fy == y) { feld
 * += "@"; continue x; } feld += "."; } feld += "\n"; } }
 * 
 * }
 */
