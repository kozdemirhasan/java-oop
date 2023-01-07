package de.kozdemir;

interface Movable {
	default int distance() {
		return 10;
	}
}

interface Jumpable {
	default int distance() {
		return 10;
	}
}

class Person implements Movable, Jumpable {
	public int distance() {
		return 10;
	}
}