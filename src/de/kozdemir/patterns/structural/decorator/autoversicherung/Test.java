package de.kozdemir.patterns.structural.decorator.autoversicherung;

public class Test {

	public static void main(String[] args) {

		Test test = new Test();
		test.run();

	}

	private void run() {

		IVersicherung versicherung = new BasisVersicherung("Basic Verischerung", 500);
		versicherung = new BesitzerAlter(versicherung, "Alte Besitzer", 100);
		versicherung = new ErstelltJahr(versicherung, "Erstellt Jahr: 2006", 40);
		versicherung = new Haupteinsatzort(versicherung, "Dorf", 30);
		versicherung = new Haupteinsatzort(versicherung, "Privaten Parkplatz", -20);
		versicherung = new Unfallgeschichte(versicherung, "SF-5", -50); // SF-5 %10 preisminderung
		
		
		KundenManager km1 = new KundenManager(
				new Person("Hasan", "Demir","Kurt-Huber Str 15", 40) ,
				versicherung, 
				new Fahrzeug("NE BC 4567", 2006, "947DSSKSI456HZ", "BMP79435843", "Gray",	new Zusatzausstattung(FelgenTyp.CHROM, AudioSystem.NORMAL )));
		

		printVersicherung(km1);
		System.out.println("Total Preis: " + versicherung.calculatePreis());

		
	}

	private void printVersicherung(KundenManager kundenManager) {				
		System.out.println(kundenManager.toString());		
		
		for(IVersicherung v : kundenManager.versicherung.getVersicherung()) {
			System.out.println(v);			
		}	

	}

}
