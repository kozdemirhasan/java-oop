package de.kozdemir.uebung05;

import java.time.LocalDate;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {

//		ProductManager pm = new ProductManager();
//		
//		Product p1 = new Product();
//		p1.setName("Lenovo T530");
//		p1.setDescription("i7 16GB RAM 500GB SSD");
//		p1.setPrice(499.99);
//		pm.addProduct(p1);
//
//		Product p2 = new Product();
//		p2.setName("Dell K21");
//		p2.setDescription("i5 8GB RAM 1000GB HDD");
//		p2.setPrice(369.99);
//		pm.addProduct(p2);
//
//		Product p3 = new Product();
//		p3.setName("Acer Inspiron");
//		p3.setDescription("i7 8GB RAM 256GB SSD");
//		p3.setPrice(399.99);
//		pm.addProduct(p3);
//		
//		
//
////		list product
//		pm.listProducts();
//		

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
