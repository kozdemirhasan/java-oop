package de.kozdemir.staubsauger;

public class Beutel {

	private final int MAX_CAPACITY;
	private int dreckImBeutel;

	public Beutel(int i) {
		MAX_CAPACITY = i;
	}

	public boolean fuellen(int dreck) {
		if (dreck + dreckImBeutel > MAX_CAPACITY) {
			return true;
		}
		dreckImBeutel += dreck;
		return false;

	}

	public int getdreckImBeutel() {

		return dreckImBeutel;

	}

}
