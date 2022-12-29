package de.kozdemir.threads.sample1;

import java.util.LinkedList;
import java.util.List;

public class Storage {
	
	private final int MAX_CAPACITY;
	
	private List<Timber> timber = new LinkedList<>(); 
	
	public Storage(int capacity) {
		MAX_CAPACITY = capacity;
	}
	
	public void store(Timber t) {
		
		if(timber.size() == MAX_CAPACITY)
			throw new RuntimeException("Lager ist voll");
		
		timber.add(t);
	}
	
	public Timber get() {
		
		if(timber.size() > 0)
			return timber.remove(0);
		
		throw new RuntimeException("Lager ist leer");
	}
	
	public int getFillLevel() {
		return timber.size();
	}
}