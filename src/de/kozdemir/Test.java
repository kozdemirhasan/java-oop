package de.kozdemir;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

public class Test {
//	private static final Consumer<Person> NUR_NACHNAMEN = p -> System.out.println(p.vorname.substring(0, 3));

	Searchable<Person> SEARCH = p -> {
		if (p.vorname.indexOf("ru") >= 0)
			System.out.println(p.vorname);
	};

	public static void main(String[] args) {

		List<Person> personen = new ArrayList<>();
		personen.add(new Person("Pet", "Parker"));
		personen.add(new Person("Bruce", "Banner"));
		personen.add(new Person("Carolhg", "Danvers"));
		personen.add(new Person("Natasru", "Romanov"));

//		Searchable<List<Person>> r = s -> {
//			for (Person p : s) {
//				if (p.vorname.indexOf("ru") >=0)
//					System.out.println(p.vorname);
//			}
//		
//		};

//		personen.forEach(NUR_NACHNAMEN);

//		for(Person p : 	MYSEARCH.printElements(personen))
//			System.out.println(p.vorname);



	}
}

class Person {

	String vorname;
	String nachname;

	public Person(String vorname, String nachname) {
		this.vorname = vorname;
		this.nachname = nachname;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [vorname=").append(vorname).append(", nachname=").append(nachname).append("]");
		return builder.toString();
	}

}

@FunctionalInterface
interface Searchable<T> {

	void printElements(T c);

}