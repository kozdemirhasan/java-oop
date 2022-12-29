package de.kozdemir.patterns.structural.decorator.autoversicherung;

import java.util.ArrayList;
import java.util.List;

public abstract class Versicherung implements IVersicherung {
	private String title;
	private double preis;
	protected IVersicherung versicherung;

	List<IVersicherung> eigenschaftens = new ArrayList<>();

	public Versicherung(IVersicherung versicherung, String title, double preis) {
		this.versicherung = versicherung;
		this.title = title;
		this.preis = preis;
		eigenschaftens.add(this);

	}

	@Override
	public double calculatePreis() {
		return versicherung.calculatePreis() + preis;
	}

	@Override
	public List<Versicherung> getVersicherung() {
		List<Versicherung> eigenschaften = versicherung.getVersicherung();
		eigenschaften.add(this);
		return eigenschaften;
	}



	public double getPreis() {
		return preis;
	}

	public List<IVersicherung> getEigenschaftens() {
		return eigenschaftens;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Versicherung [title=");
		builder.append(title);
		builder.append(", preis=");
		builder.append(preis);
		builder.append("]");
		return builder.toString();
	}

	
	

}
