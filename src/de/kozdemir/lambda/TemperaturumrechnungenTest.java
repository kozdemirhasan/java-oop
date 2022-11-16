package de.kozdemir.lambda;

public class TemperaturumrechnungenTest {

	public static void main(String[] args) {
		
		double eingabe = 30;

		Temperaturumrechnungen celvinToFahrenheit = d -> 1.8 * (d - 273) + 32;
		System.out.println(eingabe + " Celvin = " + celvinToFahrenheit.konvertieren(eingabe) + " Fahreneit");

		Temperaturumrechnungen celvinToCelcius = d -> d - 273.15;
		System.out.println(eingabe + " Celvin = " + celvinToCelcius.konvertieren(eingabe) + " Celcius");

		Temperaturumrechnungen fahrenheittoCelvin = d -> (((d - 32) * 5) / 9) + 273.15;
		System.out.println(eingabe + " Fahrenheit = " + fahrenheittoCelvin.konvertieren(eingabe) + " Celvin");

		Temperaturumrechnungen fahrenheitToCelcius = d -> ((d - 32) * 5) / 9;
		System.out.println(eingabe + " Fahrenheit = " + fahrenheitToCelcius.konvertieren(eingabe) + " Celcius");

		Temperaturumrechnungen celciustoFahrenheit = d -> (d * 1.8) + 32;
		System.out.println(eingabe + " Celcius = " + celciustoFahrenheit.konvertieren(eingabe) + " Fahrenheit");

		Temperaturumrechnungen celciusToCelvin = d -> d + 273.15;
		System.out.println(eingabe + " Celcius = " + celciusToCelvin.konvertieren(eingabe) + " Celvin");

	}

}

@FunctionalInterface
interface Temperaturumrechnungen {
	public double konvertieren(double d);
}

