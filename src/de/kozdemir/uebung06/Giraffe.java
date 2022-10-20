package de.kozdemir.uebung06;

public class Giraffe extends Tier {
	
	public Giraffe(String name) {
		super(name);
	}

	@Override
	public void frisst() {
		System.out.println(getName() + " frisst Baumzweige");
	}

	@Override
	public void pennt() {
		System.out.println(getName() + " schläft im Stehen.");
	}

}
