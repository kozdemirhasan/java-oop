package de.kozdemir;

public class Whiz {

	public static void main(String[] args) {
		A a = new A();
//		C c1 = (C) a;
		I i = ()a;
		i.meth();
//		c1.meth();

	}

}

interface I {
	void meth();
}

class A implements I {

	void A(String s) {

	}

	public void meth() {
		System.out.println("A");

	}

}

class C extends A implements I {
	public void meth() {
		System.out.println("C");
	}
}