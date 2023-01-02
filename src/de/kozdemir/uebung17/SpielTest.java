package de.kozdemir.uebung17;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SpielTest {
	
	private static final Random random = new Random();
	private static Scanner scanner= new Scanner(System.in);

	public static void main(String[] args) {
		
		ExecutorService service = Executors.newCachedThreadPool();

		List<Person> personen = new ArrayList<>();		
	
		personen.add(new Person("Hasan", random.nextInt(50), random.nextInt(50)));
		personen.add(new Person("Ahmet", random.nextInt(50), random.nextInt(50)));
		personen.add(new Person("Murat", random.nextInt(50), random.nextInt(50)));
		personen.add(new Person("Osman", random.nextInt(50), random.nextInt(50)));
		
		System.out.println("Geben Sie die X-Position des Ziels ein:");
		int x = scanner.nextInt();
		System.out.println("Geben Sie die Y-Position des Ziels ein:");
		int y = scanner.nextInt();
		
		service.execute(personen.get(0));
		service.execute(personen.get(1));
		service.execute(personen.get(2));
		service.execute(personen.get(3));
		
		Bewegung bewegung = new Bewegung(personen,x,y);

	}

}
