package de.kozdemir.time;



public class Counter {
	public static void main(String[] args) {
		int count = 0;
		while (count <= 10) {
			System.out.println("Count = " + count);
			count++;
			try {
				Thread.sleep(1_000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}

		}
		
		System.out.println("[END]");

	}

}
