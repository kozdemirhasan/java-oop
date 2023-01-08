package de.kozdemir.json2;

import java.util.Scanner;

public class HttpApiTestV2 {

	private final Scanner scanner = new Scanner(System.in);
	
	private HeldController heldController = new HeldController();
	private PostController postController = new PostController();
	
	public static void main(String[] args) {
		new HttpApiTestV2().start();
	}
	
	private void start() {
		
		try {
			
			app: while(true) {
				System.out.print("\nAuswahl: ");
				
				switch(scanner.nextLine().trim().toUpperCase()) {
					
					case "H":
						heldController.getAll();
						break;
						
					case "HO":
						System.out.print("\nID: ");
						int id = scanner.nextInt();
						scanner.nextLine(); // fix
						
						heldController.getOne(id);
						break;	
												
					case "P":
						postController.getAll();
						break;
									
					case "Q": break app;	
						
					default:
						System.out.println("Falsche Auswahl");
				}
			}
			
			System.out.println("Programm wurde beendet.");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
