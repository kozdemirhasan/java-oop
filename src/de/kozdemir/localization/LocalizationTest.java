package de.kozdemir.localization;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class LocalizationTest {

	public static void main(String[] args) {

		Locale l = new Locale("de"); // deutsch
		l = new Locale("de", "DE"); // deutsch für Deutschland
		l = Locale.forLanguageTag("de_DE");

		l = Locale.getDefault(); // Wird vom Rechner abgefragt

		// Locale.setDefault(Locale.UK);

		double zahl = 1545.435332;
		NumberFormat fmt1 = NumberFormat.getInstance(); // Verwendet das Default
		NumberFormat fmt2 = NumberFormat.getInstance(Locale.JAPAN); // Verwendet das vorgegebene Locale
		NumberFormat fmt3 = NumberFormat.getInstance();

		System.out.println(fmt1.format(zahl)); // format: zahl in String umwandeln
		System.out.println(fmt2.format(zahl));
		System.out.println(fmt3.format(zahl));

		try {
			zahl = fmt1.parse("215,99").doubleValue();
			System.out.println(zahl);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		System.out.println();
		
		
		Locale locB = new Locale.Builder().setLanguage("de").setRegion("DE").build();
	
		System.out.println(locB.getDisplayCountry());
		
		
		Locale.setDefault(Locale.CHINA);		
		for (Locale loc : Locale.getAvailableLocales()) {			
//			System.out.println(loc.getLanguage() + " " + loc.getCountry()+ " "+ loc.getVariant());
		
			System.out.println(loc.getDisplayLanguage() + " " + loc.getDisplayCountry()+ " "+ loc.getDisplayVariant()); // Wird vom Rechner abgefragt (CHINA) ->Locale.setDefault(Locale.CHINA);
			System.out.println(loc.getDisplayLanguage(Locale.ENGLISH) + " " + loc.getDisplayCountry(Locale.ENGLISH)+ " "+ loc.getDisplayVariant(Locale.ENGLISH));
			System.out.println(loc.getDisplayLanguage(Locale.FRENCH) + " " + loc.getDisplayCountry(Locale.FRENCH)+ " "+ loc.getDisplayVariant(Locale.FRENCH));
			
			System.out.println();
		}

	}

}
