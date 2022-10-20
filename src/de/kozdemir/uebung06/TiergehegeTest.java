package de.kozdemir.uebung06;

public class TiergehegeTest {
	
	public static void main(String[] args) {
		
		// Gehege wird erstellt
		Tiergehege gehege = new Tiergehege();
		
		// Tier wird erstellt
		Tier tier = new Loewe("Alex");
		//System.out.println(tier);
		
		// Tier wird einem Gehege hinzugefügt
		gehege.addTier(tier);
		
		// Zeites Tier wird erzeugt
		// Tier ist eine abstrakte Klasse d.h. darf nicht instanziert werden
		//tier = new Tier("Melmet");
		//gehege.addTier(tier); // es wird dem Gehege hinzugefügt
		
		Giraffe g = new Giraffe("Melman");
		gehege.addTier(g);
		
		gehege.addTier(new Zebra("Marty"));
		
		System.out.println(gehege);
		
		System.out.println();
		
		gehege.starteFuetterung();
		gehege.starteNachtruhe();
	}
}
