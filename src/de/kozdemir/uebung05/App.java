package de.kozdemir.uebung05;

import java.time.LocalDate;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		

		final Scanner scanner = new Scanner(System.in);

		final ProductManager productManager = new ProductManager();

		Product product;

		while (true) {
			int wahl = menu();

			System.out.print("Normales (N) oder VerdeblichesProduckt (V): ");
			if (scanner.next().trim().equalsIgnoreCase("n"))
				product = new Product();
			else
				product = new VerderblichesProduct();

			System.out.print("Name: ");
			product.setName(scanner.next());

			scanner.nextLine(); // fix
			System.out.print("Beschreibung: ");
			product.setDescription(scanner.nextLine());

			System.out.print("Preis: \n");
			product.setPrice(Double.parseDouble(scanner.next()));

			// ***
			if (product instanceof VerderblichesProduct) {
				scanner.nextLine();
				System.out.print("Verfallsdatum (dd/MM/YYYY) : \n"); // Warum kann ich nicht hier . statt / verwenden?

				String str = scanner.next();
				String[] strDatum = str.split("/");

				((VerderblichesProduct) product).setVerfallsDatum(LocalDate.of(Integer.parseInt(strDatum[2]),
						Integer.parseInt(strDatum[1]), Integer.parseInt(strDatum[0])));
			}

			productManager.addProduct(product);

			System.out.print("Weiter? [j/n]: \n");
			if (scanner.next().trim().equalsIgnoreCase("n"))
				break;

		}

		productManager.listProducts();

		System.out.print("Verdebliches Produckt auflisten? (J/N) : \n");
		if (scanner.next().trim().equalsIgnoreCase("j"))
			productManager.listVerdeblishesProducts();
		else
			System.exit(0);

	}

	private static int menu() {

		System.out.println( "****************************************\n" +
							"*               MENU                   *\n" +
							"****************************************\n" +
							"*  N: Normales Product erstellen       *\n" +
							"*  V: Verdebliches Product erstellen   *\n" +
							"*  L: Product list                     *\n" +
							"*  X: Verdebliches PRoduct list        *\n" +
							"*  Q: Exit                             *\n" +
							"*                                      *\n" +
							"****************************************\n");

		return 1;/////

	}

}
