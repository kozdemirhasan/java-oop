package de.kozdemir.threads.soketExample.queue;



import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class DataQueue {

	private static BlockingQueue<String> DATA_QUEUE = new ArrayBlockingQueue<>(1024);

	public static boolean add(String e) {
		return DATA_QUEUE.add(e);
	}

	public static String take() throws InterruptedException {
		return DATA_QUEUE.take();
	}	
}
