package de.kozdemir.uebung05;

import java.time.LocalDate;

public class VerderblichesProduct extends Product{

	private LocalDate verfallsDatum;

	
	
	public LocalDate getVerfallsDatum() {
		return verfallsDatum;
	}

	public void setVerfallsDatum(LocalDate verfallsDatum) {
		this.verfallsDatum = verfallsDatum;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VerderblichesProdukt [verfallsDatum=").append(verfallsDatum).append(", toString()=")
				.append(super.toString()).append("]");
		return builder.toString();
	}





	
	
}
