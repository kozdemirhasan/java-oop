package de.kozdemir.threads;

public class ThreadTest {

	public static void main(String[] args) {

		System.out.println(Thread.currentThread().getName() + " START");

		// 1. Methode
		Thread t1 = new Thread(new Aufgabe());

		// 2. Methode
		Thread t2 = new ThreadMitAufgabe();

		// 3. Methode
		Runnable aufgabe = () -> {
			for (int i = 0; i < 10; i++) {

				try {
					Thread.sleep(500);
				} catch (InterruptedException e) { // Tritt ein, wenn der Thread während des Schlafs abgebrochen wird
					e.printStackTrace();
				}

				System.out.println(Thread.currentThread().getName() + ": " + i);
			}

		};
		Thread t3 = new Thread(aufgabe);
		
		t1.start();
		t2.start();
		t3.start();

//		t1.run();
//		t2.run();
//		t3.run();
		

		System.out.println(Thread.currentThread().getName() + " ENDE");

	}

	public static void count() {
		for (int i = 0; i < 10; i++) {

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(Thread.currentThread().getName() + ": " + i);
		}
	}
}

class Aufgabe implements Runnable {

	@Override
	public void run() {
		ThreadTest.count();
	}
}

class ThreadMitAufgabe extends Thread {

	@Override
	public void run() {
		ThreadTest.count();
	}
}
