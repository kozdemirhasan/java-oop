package de.kozdemir.test;

public class Test {

	public static void main(String[] args) {

		Person p1 = new Teacher("name"); //SP CP OCT CP CS
		Student s1 = new Student();

	}

}

class Person {
	Person() {
		System.out.println("CP ");
	}
	Person(String s) {
		System.out.println("PS ");
	}

	static {
		System.out.println("SP ");
	}
}

class Student extends Person {
	Student() {
		System.out.println("CS ");
	}
}

class Teacher extends Person {
	Teacher() {
	
		System.out.println("CT ");
	}

	 Teacher(String s) {
//		 super("xxx");
		System.out.println("OCT ");
	}
}
