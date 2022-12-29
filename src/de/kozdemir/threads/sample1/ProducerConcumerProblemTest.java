package de.kozdemir.threads.sample1;

public class ProducerConcumerProblemTest {

	public static void main(String[] args) {
		
		Storage storage = new Storage(20);
		
		new Thread(new Lumberjack("Bob", storage)).start();
		new Thread(new Lumberjack("Hans", storage)).start();
		new Thread(new Lumberjack("Peter", storage)).start();
		new Thread(new Lumberjack("Carol", storage)).start();
		new Thread(new Lumberjack("Natasha", storage)).start();
		
		new Thread(new Merchant("NATASCHA", storage)).start();
		new Thread(new Merchant("ROB", storage)).start();
//		new Thread(new Merchant("STEFAN", storage)).start();
		

		
		

	}

}
