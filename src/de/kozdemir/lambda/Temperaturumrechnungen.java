package de.kozdemir.lambda;

public class Temperaturumrechnungen {

	public static void main(String[] args) {
		double eingabe = 30;

		CelvinToFahrenheit celvinToFahrenheit = d -> 1.8 * (d - 273) + 32;
		System.out.println(eingabe + " Celvin = " + celvinToFahrenheit.konvertieren(eingabe) + " Fahreneit");

		CelvinToCelcius celvinToCelcius = d -> d - 273.15;
		System.out.println(eingabe + " Celvin = " + celvinToCelcius.konvertieren(eingabe) + " Celcius");

		FahrenheitToCelvin fahrenheittoCelvin = d -> (((d - 32) * 5) / 9) + 273.15;
		System.out.println(eingabe + " Fahrenheit = " + fahrenheittoCelvin.konvertieren(eingabe) + " Celvin");

		FahrenheitToCelcius fahrenheitToCelcius = d -> ((d - 32) * 5) / 9;
		System.out.println(eingabe + " Fahrenheit = " + fahrenheitToCelcius.konvertieren(eingabe) + " Celcius");

		CelciusToFahrenheit celciustoFahrenheit = d -> (d * 1.8) + 32;
		System.out.println(eingabe + " Celcius = " + celciustoFahrenheit.konvertieren(eingabe) + " Fahrenheit");

		CelciusToCelvin celciusToCelvin = d -> d + 273.15;
		System.out.println(eingabe + " Celcius = " + celciusToCelvin.konvertieren(eingabe) + " Celvin");

	}

}

@FunctionalInterface
interface CelvinToFahrenheit {
	public double konvertieren(double d);
}

@FunctionalInterface
interface CelvinToCelcius {
	public double konvertieren(double d);
}

@FunctionalInterface
interface FahrenheitToCelvin {
	public double konvertieren(double d);
}

@FunctionalInterface
interface FahrenheitToCelcius {
	public double konvertieren(double d);
}

@FunctionalInterface
interface CelciusToFahrenheit {
	public double konvertieren(double d);
}

@FunctionalInterface
interface CelciusToCelvin {
	public double konvertieren(double d);
}
