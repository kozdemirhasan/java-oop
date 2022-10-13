package uebung03_robot;

public class Roboter {

	public String name;
	public int x=10; // Default 0
	public int y=10; // Default 0

	public static final String[] RICHTUNGEN = { "Osten", "Süden", "Westen", "Norden" };
	private int richtung; // 0 = Osten(rechts), 1 = Süden(unten), 2 = Westen(links), 3 = Norden(oben)


	public Roboter(String name) {
		this.name = name;		

	}

	public Roboter(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;


	}

	public void sagHallo() {
		System.out.println("Hi, ich bin " + name);
	}

	public void drehungRechts() {
		richtung = ++richtung % 4;
	}

	public void drehungLinks() {
		richtung = (richtung + 3) % 4;
	}

	public void zeigeRichtung() {
		System.out.println(RICHTUNGEN[richtung]);
	}

	public void schrittVorwaerts() {

		// TODO: Bewegung in negativen Berich verhindern
		switch (richtung) {
		case 0:
			x++;
			break;

		case 1:
			y++;
			break;

		case 2:
			x--;
			break;

		case 3:
			y--;
			break;
		}
		
	}

	public void schrittRueckwaerts() {
		switch (richtung) {
		case 0:
			x--;
			break;

		case 1:
			y--;
			break;

		case 2:
			x++;
			break;

		case 3:
			y++;
			break;
		}
	}

	public int getRichtung() {
		return richtung;
	}
	
	
	public Roboter controller(String anleitung, Roboter robot) {

		char[] ch = anleitung.toCharArray();
		for (char c : ch) {
			switch (c) {

			case '<':
				// back
//				System.out.println("rückwärts");
				robot.schrittRueckwaerts();
				break;

			case '>':
//				System.out.println("vorwärts");
				// forward
				robot.schrittVorwaerts();
				break;

			case 'l':
				// left
//				System.out.println("drehung nach Links ");
				robot.drehungLinks();
				break;
			case 'r':
				// right
//				System.out.println("drehung nach Rechts");
				robot.drehungRechts();
				break;

			default:
				System.out.println(c + " ist ungültig!");

			}
		}
		System.out.println(robot.toString());
		return robot;
	}

	@Override
	public String toString() {
		return "Position: [x=" + x + ", y=" + y + "]," + " Richtung: "
				+ RICHTUNGEN[getRichtung()]+"\n";
	}

}
