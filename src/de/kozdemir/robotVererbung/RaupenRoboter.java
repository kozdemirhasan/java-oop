package de.kozdemir.robotVererbung;

public class RaupenRoboter extends Robot {

	public RaupenRoboter(String bezeichung, double preis) {
		super(bezeichung, preis);
		
	}

	public void bewegung() {
		System.out.println("*** Raupenroboter fahrt langsam *** ");
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RaupenRoboter [")
		.append(super.toString()).append("]");
		return builder.toString();
	}

	
	
	

}
