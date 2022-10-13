package de.kozdemir.uebung02_wuerfelBecker.diceSpiel;


public class DiceCupTest {

	
	public static void main(String[] args) {
				
		DiceCup cup = new DiceCup();
		System.out.println(cup.roll()); // 1 WÃ¼rfel-Wurf
		
		System.out.println();
		
		for(int result : cup.roll(4)) {
			System.out.println(result);
		}
		
		System.out.println();
		
		cup = new DiceCup(10);
		System.out.println(cup.roll());
		
		System.out.println();
		
		int[] results = cup.roll(4);
		
		for(int result : results) {
			System.out.println(result);
		}
		
		System.out.println();
		
		System.out.println(cup.stats(results));
	}
}
