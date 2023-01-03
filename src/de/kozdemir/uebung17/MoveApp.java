package de.kozdemir.uebung17;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MoveApp {

	private static final Random random = new Random();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		ExecutorService service = Executors.newCachedThreadPool();
		List<Person> personen = new ArrayList<>();

		personen.add(new Person("Hasan", random.nextInt(20), random.nextInt(20)));
		personen.add(new Person("Ahmet", random.nextInt(20), random.nextInt(20)));
		personen.add(new Person("Murat", random.nextInt(20), random.nextInt(20)));
		personen.add(new Person("Osman", random.nextInt(20), random.nextInt(20)));

		System.out.println("Herzlic Willkommen zu unserem MoveApp\n" + "[X = Neu position, Q= Quit]\n");

		System.out.println("Geben Sie die X-Position des Ziels ein:");
		int x = scanner.nextInt();
		System.out.println("Geben Sie die Y-Position des Ziels ein:");
		int y = scanner.nextInt();

		for (Person p : personen) {
			p.setTarget(x, y);
			service.execute(p);
		}

		app: while (true) {

			switch (scanner.nextLine().trim().toUpperCase()) {

			case "X":
//					System.out.println("Geben Sie die neu X-Position des Ziels ein:");
//					x = scanner.nextInt();
//					System.out.println("Geben Sie die neu Y-Position des Ziels ein:");
//					y = scanner.nextInt();

				for (Person p : personen) {
					p.setTarget(0, 0);
				}
				break;

			case "Y":
				for (Person p : personen) {
					p.setTarget(10, 10);
				}
				break;

			case "Z":
				for (Person p : personen) {
					p.setTarget(20, 20);
				}
				break;

			case "Q":
				break app;
			}
		}

		service.shutdownNow();

	}

}
