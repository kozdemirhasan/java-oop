package de.kozdemir.lambda;

public class GruessTest {

	public static void main(String[] args) {

		Begueruessen1 b1 = s -> System.out.println("Merhaba " + s + "!");
		Begueruessen1 b2 = s -> System.out.println("Hallo " + s + "!");
		Begueruessen1 b3 = s -> System.out.println("Hello " + s + "!");

		b1.gruessen("Hasan");
		b2.gruessen("Hasan");
		b3.gruessen("Hasan");

		System.out.println("*********************************");

		Begueruessen2 bs1 = (String s) -> "Merhaba " + s + "!";
		Begueruessen2 bs2 = s -> "Hallo " + s + "!";
		Begueruessen2 bs3 = s -> "Hello " + s + "!";
		System.out.println(bs1.gruessen("Thomaz"));
		System.out.println(bs2.gruessen("Thomaz"));
		System.out.println(bs3.gruessen("Thomaz"));

		System.out.println("*********************************");

		Begueruessen3 bn = new Begueruessen3() {
			@Override
			public String gruessen(String kimi) {
				return "Merhaba " + kimi + " ***";
			}
		};
		System.out.println(bn.gruessen("Peter"));

		System.out.println("*********************************");

		f(new Begueruessen1() {
			@Override
			public void gruessen(String kimi) {
				System.out.println("HALLO " + kimi);

			}
		});

	}

	public static void f(Begueruessen1 b1) {
		b1.gruessen("Mustafa");
	}

}

@FunctionalInterface
interface Begueruessen1 {
	public void gruessen(String kimi);
}

@FunctionalInterface
interface Begueruessen2 {
	public String gruessen(String kimi);
}

@FunctionalInterface
interface Begueruessen3 {
	public String gruessen(String kimi);
}