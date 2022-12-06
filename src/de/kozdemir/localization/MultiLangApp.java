package de.kozdemir.localization;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;

public class MultiLangApp {

	public static void main(String[] args) {
		
		
		Scanner s = new Scanner(System.in);
		System.out.print("Sprache [DE, EN, FR]: ");
		String langStr = s.nextLine();
		
		Map<String, Locale> languages = new HashMap<>();
		languages.put("DE", Locale.GERMANY);
		languages.put("FR", Locale.FRANCE);
		languages.put("EN", Locale.US);
		
		Locale lang = languages.getOrDefault(langStr.trim().toUpperCase(), Locale.US);
		Locale.setDefault(lang);
		
		lang = Locale.JAPAN;
		
//		Map<String, Integer> werte = new HashMap<>();
//		werte.put("DE", 100);
//		werte.put("FR", 200);
//		werte.put("EN", 300);
//		
//		werte.get("ES"); // liefert eine null
//		werte.getOrDefault("ES", 0); // liefert eine 0
		
		
		// Reihenfolge
		// _de_DE
		// _de
		// standard auf diesem Rechner
		// Sprachdatei ohne Endung
		// Exception
		ResourceBundle bundle = ResourceBundle.getBundle("de.kozdemir.localization.labels", lang);
		
		final NumberFormat NUM_FMT = NumberFormat.getInstance(lang);
		//final NumberFormat NUM_FMT = NumberFormat.getCurrencyInstance(lang);
		
		
		DecimalFormat DEC_FMT = new DecimalFormat("##0.##");
		
		System.out.println(bundle.getString("start"));
		
		System.out.println(bundle.getString("name.question"));
		System.out.print(bundle.getString("name.label"));
		String name = s.nextLine();
		System.out.println(bundle.getString("welcome.hi") + " " + name + ". " + bundle.getString("welcome"));
		
		System.out.print(bundle.getString("price.label"));
		String priceStr = s.nextLine();
		
//		double p = s.nextDouble(); // Verwenden hier automatisch das Default-Locale
//		System.out.println(p);
//		s.nextLine();
		
		double price = 0;
		
		try {
//			price = NUM_FMT.parse(priceStr).doubleValue();
//			System.out.println(NUM_FMT.format(price));
//			System.out.println("Inkl. MwSt " + DEC_FMT.format(price * 1.19));
			
			price = DEC_FMT.parse(priceStr).doubleValue();
			System.out.println(DEC_FMT.format(price));
			System.out.println("Inkl. MwSt " + DEC_FMT.format(price * 1.19));
		} 
		catch (ParseException e) {
			System.out.println("Ungültige Zahl!");
		}
		
		System.out.println(bundle.getString("end"));
		System.out.println(bundle.getString("txt"));
		
		
		System.out.println();
		
		LocalDateTime zeitpunkt = LocalDateTime.now();
		DateTimeFormatter fmt1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
		DateTimeFormatter fmt2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		DateTimeFormatter fmt3 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
		DateTimeFormatter fmt4 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
		
		System.out.println(fmt1.format(zeitpunkt));
		System.out.println(zeitpunkt.format(fmt2));
		//System.out.println(zeitpunkt.format(fmt3));
		//System.out.println(zeitpunkt.format(fmt4));
		
		System.out.println();
		
		ZonedDateTime zdt = ZonedDateTime.now();
		System.out.println(zdt.format(fmt3));
		System.out.println(zdt.format(fmt4));
		
		System.out.println();
		
		fmt1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		fmt2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		fmt3 = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		fmt4 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		System.out.println(zeitpunkt.toLocalDate().format(fmt1));
		System.out.println(zeitpunkt.toLocalDate().format(fmt2));
		System.out.println(zeitpunkt.toLocalDate().format(fmt3));
		System.out.println(zeitpunkt.toLocalDate().format(fmt4));
		
		System.out.println();
		
		price = 99.235;
		System.out.println(String.format("%.2f", price)); // Orientiert sich am Default-Locale
		System.out.println(String.format(Locale.CHINA, "%.2f", price));

	}
}
