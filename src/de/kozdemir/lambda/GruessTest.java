package de.kozdemir.lambda;

public class GruessTest {

	public static void main(String[] args) {

		Begueruessen b1 = s -> System.out.println("Merhaba " + s + "!");
		Begueruessen b2 = s -> System.out.println("Hallo " + s + "!");
		Begueruessen b3 = s -> System.out.println("Hello " + s + "!");

		b1.gruessen("Hasan");
		b2.gruessen("Hasan");
		b3.gruessen("Hasan");

	

		System.out.println("----------------------------------------");
		
		f(new Begueruessen() {
			@Override
			public void gruessen(String kimi) {
				System.out.println("HALLO " + kimi);
				
			}
		});
		
		System.out.println("----------------------------------------");

		Begueruessen2 bn = new Begueruessen2() {
			@Override
			public String gruessen(String kimi) {
				return "Merhaba " + kimi + " ***";
			}
		};
		System.out.println(bn.gruessen("Peter"));
		
	
		System.out.println("----------------------------------------");


	}

	public static void f(Begueruessen b) {
		b.gruessen("Mustafa");
	}

}

@FunctionalInterface
interface Begueruessen {
	public void gruessen(String wenn);
}

@FunctionalInterface
interface Begueruessen2 {
	public String gruessen(String wenn);
}


