package de.kozdemir.robotVererbung;

public class RadRoboter extends Robot {

	public RadRoboter(String bezeichung, double preis) {
		super(bezeichung, preis);
	
	}

	public void bewegung() {
		System.out.println("*** Radroboter fahrt schnell *** ");
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RadRoboter [")
		.append(super.toString()).append("]");
		return builder.toString();
	}


	
	

}
