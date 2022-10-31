package de.kozdemir.collection;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {

	public static void main(String args[]) {

		Set<Person> list = new TreeSet<>();
		list.add(new Person("Hasan", 41));
		list.add(new Person("Ali", 32));

		list.forEach(System.out::println);

	}

}

class Person implements Comparable<Person>{
	String name;
	int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [name=").append(name).append(", age=").append(age).append("]");
		return builder.toString();
	}



	@Override
	public int compareTo(Person o) {		
		return name.compareTo(o.name);
	}

}