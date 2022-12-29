package de.kozdemir.threads.sample1;

public class Merchant implements Runnable {
	
	private final Storage storage;
	
	private final String name;
	
	public Merchant(String name, Storage storage) {
		this.name = name;
		this.storage = storage;
	}

	@Override
	public void run() {
		while(true) {
			try {
				synchronized (storage) {
					
					// wait und notify dürfen nur innerhalb eines Synchronisations-Block verwendet werden
					
					System.out.println(name + ": will Holz entnehmen");
					
					try {
						storage.get();
						System.out.println(name + ": hat erfolgreich Holz entnommen. Füllstand " + storage.getFillLevel());
						storage.notify();
					}
					catch(RuntimeException e) {
						System.out.println(name + ": kann keine Holz entnehmen, da das Lager leer ist.");
						storage.wait(); // Wartet hier, bis er mit notify wieder aktiviert wird. LOCK wird abgegeben
					}
					System.out.println();
				}
			
				Thread.sleep(1000); // beim sleep wird der LOCK nicht abgegeben
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
