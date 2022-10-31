package de.kozdemir.staubsauger;


public class App {

	public static void main(String[] args) {

		System.out.println("START");
		

		Staubsauger sauger = new Staubsauger("AEG Vampire", 100);
		System.out.println(sauger.toString());

		try {
			sauger.saugen(10);
			System.out.println("Stand: " + sauger.getBeutelInhalt());
			sauger.saugen(20);
			System.out.println("Stand: " + sauger.getBeutelInhalt());
			sauger.saugen(22);
			System.out.println("Stand: " + sauger.getBeutelInhalt());
			sauger.saugen(70);
			System.out.println("Stand: " + sauger.getBeutelInhalt());
	
		} catch (BeutelVollException e) {
			System.out.println("Der Beutel ist voll: " + sauger.getBeutelInhalt() );
		
		}
	
		System.out.println("ENDE");

	}
}
