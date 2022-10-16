package de.kozdemir.uebung05;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {

	private List<Product> products;

	public ProductManager() {
		products = new ArrayList<>();
	}

	public void addProduct(Product product) {
		products.add(product);

	}

	public void listProducts() {

		System.out.printf("%5s | %-15s | %-25s | %-30s | %s \n", "id", "Name", "Beschreibung", "Seit", "Preis");
		System.out.println(
				"---------------------------------------------------------------------------------------------------");

		for (Product product : products) {
			System.out.printf("%5s | %-15s | %-25s | %-30s | %.2f EUR \n", product.getId(), product.getName(),
					product.getDescription(), product.getCreatedAt(), product.getPrice());
		}
		System.out.println();
	}

	public void listVerdeblishesProducts() {

		System.out.printf("%5s | %-15s | %-25s | %-30s | %-30s | %s \n", "id", "Name", "Beschreibung", "Verfallsdatum",
				"Seit", "Preis");
		System.out.println(
				"---------------------------------------------------------------------------------------------------");

		try {
			for (Product product : products) {
				System.out.printf("%5s | %-15s | %-25s | %-30s | %-30s | %.2f EUR \n", product.getId(), product.getName(),
						product.getDescription(), ((VerderblichesProduct) product).getVerfallsDatum(),
						product.getCreatedAt(), product.getPrice());

			}

		}catch(Exception ex){
			System.out.println("Fehler!!!");
		}
	
	}

}
