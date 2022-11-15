package de.kozdemir.uebung04_product;

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
//		for (Product p : products) {
//			System.out.println(p.toString());
//		}

		System.out.printf("%5s | %-15s | %-25s | %-30s | %s \n", "id", "Name", "Beschreibung", "Seit", "Preis");
		System.out.println(
				"---------------------------------------------------------------------------------------------------");

		for (Product product : products) {
			System.out.printf("%5s | %-15s | %-25s | %-30s | %.2f EUR \n", product.getId(), product.getName(),
					product.getDescription(), product.getCreatedAt(), product.getPrice());

		}

	}
	
	
}
