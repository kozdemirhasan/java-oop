package de.kozdemir;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Dog {

	public static void main(String[] args) {

//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.YYYY HH:mm");// 15 10 22 11 10 
//		
//		LocalDateTime ldt = LocalDateTime.of(2015, 10, 10, 11, 22);
//		
//		LocalDateTime ldt2 = LocalDateTime.now();
//		
//		
//		System.out.println(dtf.format(ldt2) );
//		System.out.println(ldt2.format(dtf)  );

//		LocalDate l = LocalDate.of(2015,2,2).now();
//		l.plusYears(3);
//		System.out.println(l);

		LocalDateTime l = LocalDateTime.of(LocalDate.of(2015, 2, 27), LocalTime.of(11, 22));
		
		l = l.withDayOfMonth(28);
		
		System.out.println(l.getDayOfWeek() + ":" + l.getDayOfMonth() + ":" + l.getHour());
		
		System.out.println(LocalDate.ofYearDay(2015, 364));

	}

}
