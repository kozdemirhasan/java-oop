package de.kozdemir.uebung06;

public abstract class Tier {
	
	private final String name;

	public Tier(String name) {
		this.name = name;
	}
	
	// Hier wird festgelegt, was implementiert/eingebaut werden muss
	public abstract void frisst();
	
	// Hier wird festgelegt, was implementiert/eingebaut werden muss
	public abstract void pennt();
	
	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}
}
