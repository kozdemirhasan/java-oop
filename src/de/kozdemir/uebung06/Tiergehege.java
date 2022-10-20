package de.kozdemir.uebung06;

import java.util.ArrayList;
import java.util.List;

// IS-A: extends und implements
public class Tiergehege {
	
	// HAS-A
	private List<Tier> plaetze = new ArrayList<>();
	
	// Hier kann ein Tier oder Objekte von Tier abgeleiteter Klassen übergeben werden
	public void addTier(Tier tier) {
		plaetze.add(tier);
	}
	
	public void starteFuetterung() {
		for(Tier t : plaetze) {
			t.frisst();
		}
	}
	
	public void starteNachtruhe() {
		for(Tier t : plaetze) {
			t.pennt();
		}
	}
	
	@Override
	public String toString() {
		return plaetze.toString();
	}
}
