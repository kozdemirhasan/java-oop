package de.kozdemir.uebung08;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ProductManager {

//	private List<Product> products;
	private Set<Product> products;

	public ProductManager() {
//		products = new ArrayList<>();
		products = new TreeSet<>();
		
	}

	public void addProduct(Product product) {
		products.add(product);

	}

	public void listProducts() {
		
		DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

		System.out.printf("%5s | %-15s | %-25s | %-30s | %s \n", "id", "Name", "Beschreibung", "Seit", "Preis");
		System.out.println(
				"---------------------------------------------------------------------------------------------------");

		for (Product product : products) {
			System.out.printf("%5s | %-15s | %-25s | %-30s | %.2f EUR \n", product.getId(), product.getName(),
					product.getDescription(), product.getCreatedAt().format(dateTimeFormat), product.getPrice());

		}

	}

}
