package de.kozdemir;

public class AnomalieTest {

	public static void main(String[] args) {

		Thread t1 = new Thread(new Counter());
		t1.setName("Peter");
		Thread t2 = new Thread(new Counter());
		Thread t3 = new Thread(new Counter());

		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Counter.count);
	}
}

class Counter implements Runnable {

	public static int count = 0;

	@Override
	public void run() {
		for (int i = 0; i < 10_000; i++) {
			up();
			down();
		}
	}

	public  void up() {
		count += 1;
		System.out.println(Thread.currentThread().getName()+ ": "+ count);
	}

	public  void down() {
		count -= 1;
		System.out.println(Thread.currentThread().getName()+ ": "+ count);
	}
}