package de.kozdemir.robotVererbung;

public class Robot {

	private String bezeichung;
	private double preis;

	public Robot(String bezeichung, double preis) {
		this.bezeichung = bezeichung;
		this.preis = preis;
	}

	public void bewegung() {

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("bezeichung=").append(bezeichung)
		.append(", preis=").append(preis);
		return builder.toString();
	}
	
	


//	public String getBezeichung() {
//		return bezeichung;
//	}
//
//
//	public void setBezeichung(String bezeichung) {
//		this.bezeichung = bezeichung;
//	}
//
//
//	public double getPreis() {
//		return preis;
//	}
//
//
//	public void setPreis(double preis) {
//		this.preis = preis;
//	}
	
	

}
