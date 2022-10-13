package de.kozdemir.uebung04_product;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {

		ProductManager pm = new ProductManager();
		
		Product p1 = new Product();
		p1.setName("Lenovo T530");
		p1.setDescription("i7 16GB RAM 500GB SSD");
		p1.setPrice(499.99);
		pm.addProduct(p1);

		Product p2 = new Product();
		p2.setName("Dell K21");
		p2.setDescription("i5 8GB RAM 1000GB HDD");
		p2.setPrice(369.99);
		pm.addProduct(p2);

		Product p3 = new Product();
		p3.setName("Acer Inspiron");
		p3.setDescription("i7 8GB RAM 256GB SSD");
		p3.setPrice(399.99);
		pm.addProduct(p3);
		
		

//		list product
		pm.listProducts();
		

//		final Scanner scanner = new Scanner(System.in);
//
//		final ProductManager pm = new ProductManager();
//
//		while (true) {
//			Product p = new Product();
//
//			System.out.print("Name: ");
//			p.setName(scanner.next());
//
//			scanner.nextLine(); // fix
//			System.out.print("\nBeschreibung: ");
//			p.setDescription(scanner.nextLine());
//
//			System.out.print("\nPreis: ");
//			p.setPrice(Double.parseDouble(scanner.next()));
//
//			pm.addProduct(p);
//
//			System.out.print("Weiter? [j/n]: ");
//			if (scanner.next().trim().equalsIgnoreCase("n"))
//				break;
//		}
//		pm.listProducts();

	}

}
