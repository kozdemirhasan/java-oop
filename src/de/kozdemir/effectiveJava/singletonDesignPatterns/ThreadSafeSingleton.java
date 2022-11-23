package de.kozdemir.effectiveJava.singletonDesignPatterns;

public class ThreadSafeSingleton {

	private static ThreadSafeSingleton instance;

	private ThreadSafeSingleton() {
	}

	public static synchronized ThreadSafeSingleton getInstance() {
		if (instance == null) {
			instance = new ThreadSafeSingleton();
		}
		return instance;
	}
	
	//double-checked locking
	public static ThreadSafeSingleton getInstanceUsingDoubleLocking() {
	    if (instance == null) {
	        synchronized (ThreadSafeSingleton.class) {
	            if (instance == null) {
	                instance = new ThreadSafeSingleton();
	            }
	        }
	    }
	    return instance;
	}

}