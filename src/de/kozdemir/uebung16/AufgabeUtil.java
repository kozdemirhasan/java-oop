package de.kozdemir.uebung16;

import java.util.HashSet;
import java.util.Random;

public class AufgabeUtil {

	private static final Random random = new Random();

	private AufgabeUtil() {

	}

	public static HashSet<String> aufgabeGeben() {

		HashSet<String> hashset = new HashSet<>();

		for (int i = 0; i < 6; i++) {

			if(hashset.add(Aufgaben.values()[random.nextInt(6)].toString())) {
				
			}else {
				--i;
			}
		}

		return hashset;

	}

}
