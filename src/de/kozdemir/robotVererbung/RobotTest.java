package de.kozdemir.robotVererbung;

public class RobotTest {

	public static void main(String[] args) {

		RaupenRoboter raupen1 = new RaupenRoboter("RAUPEN 65",2300);
		
		RadRoboter rad1 = new RadRoboter("RADROBOTER 571", 3800);
		
		System.out.println(raupen1.toString());
		raupen1.bewegung();
		
		System.out.println();
		
		System.out.println(rad1.toString());
		rad1.bewegung();

	}

}
