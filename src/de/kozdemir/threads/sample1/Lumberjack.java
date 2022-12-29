package de.kozdemir.threads.sample1;

public class Lumberjack implements Runnable {
	
	private final Storage storage;
	
	private final String name;
	
	public Lumberjack(String name, Storage storage) {
		this.name = name;
		this.storage = storage;
	}

	@Override
	public void run() {
		while(true) {
			try {
				synchronized (storage) {
					System.out.println(name + ": will Holz einlagern");
					
					try {
						storage.store(new Timber());
						System.out.println(name + ": hat erfolgreich Holz eingelagert. Füllstand " + storage.getFillLevel());
						storage.notify();
					}
					catch(RuntimeException e) {
						System.out.println(name + ": kann keine Holz einlagern, da das Lager voll ist.");
						storage.wait();
					}
				System.out.println();
				}
			
			
				Thread.sleep(1000);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
