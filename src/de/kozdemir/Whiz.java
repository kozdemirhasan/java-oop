package de.kozdemir;

import java.time.LocalDate;


public class Whiz {

	
	public static void main(String[] args) {
		
		int i = Runtime.getRuntime().availableProcessors();
	
		System.out.println(i);

		LocalDate lc = LocalDate.of(2015, 1, 31).now();
		lc =lc.plusYears(3);
		System.out.println(lc);
		
		System.out.println(LocalDate.ofYearDay(2015,365));
		
	}
}
